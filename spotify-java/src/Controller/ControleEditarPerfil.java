package Controller;

import DAO.UsuarioDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Usuario;
import View.EditarPerfil;
import View.Perfil;

public class ControleEditarPerfil {  
    private EditarPerfil view;
    private Usuario usuario;
    private String novo_usuario, novo_nome, nova_senha;
    private String usuario_antigo, nome_antigo, senha_antiga;
    private String senha_inserida;
    
    public ControleEditarPerfil(EditarPerfil view, Usuario usuario) {
        this.view = view;
        this.usuario = usuario;
    }

    public ControleEditarPerfil(EditarPerfil view) {
        this.view = view;

    }
    
    public void redirectPerfil(Usuario usuario){
                view.setVisible(false);
                Perfil p = new Perfil(usuario);
                p.setVisible(true);

    }
       
    public void editarPerfil(Usuario usuario){
        usuario_antigo = usuario.getUsuario();
        nome_antigo = usuario.getNome();
        senha_antiga = usuario.getSenha();
        
        novo_usuario = view.getTxt_novo_user().getText();
        novo_nome = view.getTxt_novo_nome().getText();
        nova_senha = view.getTxt_nova_senha().getText();
        senha_inserida = view.getTxt_senha_antiga().getText();
        
        if (novo_usuario.isEmpty()){
            novo_usuario = usuario_antigo;
        } if (novo_nome.isEmpty()){
            novo_nome = nome_antigo;
        } if (nova_senha.isEmpty()){
            nova_senha = senha_antiga;
        }       
        
        if(senha_antiga.equals(senha_inserida)){
            Usuario usuario_atualizado = new Usuario(novo_usuario, novo_nome, nova_senha);
            Usuario usuarioAntigo = new Usuario(usuario_antigo, nome_antigo, senha_antiga);
            Conexao conexao = new Conexao();
            
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                
                //user ja existente
                if (dao.usuarioExistente(usuario_atualizado)){
                     JOptionPane.showMessageDialog(null,
                    "Usuário já utilizado!",
                    "Aviso",
                    JOptionPane.INFORMATION_MESSAGE);
                    
                     return;                   
                } else {
                    dao.atualizarUsuario(usuario_atualizado, usuarioAntigo);  
                    JOptionPane.showMessageDialog(view, "Dados atualizados com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    redirectPerfil(usuario_atualizado);
                }
            } catch(SQLException e){
                e.printStackTrace(); // Mostra o erro no console
                JOptionPane.showMessageDialog(view, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(view, "Senha incorreta!", "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }
}
