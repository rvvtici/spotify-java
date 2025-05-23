
package Controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import Model.Usuario;
import View.Home;
import View.Historico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControleHistorico {
        private Historico view;
        private Usuario usuario;

        public ControleHistorico(Historico view, Usuario usuario){
            this.view = view;
            this.usuario = usuario;
        }

        public ControleHistorico(Historico view){
            this.view = view;
        }
    
    
    
        public void redirectPaginaHome(Usuario usuario){     
            view.setVisible(false);
            Home h = new Home(usuario);
            h.setVisible(true);
    }
        
        public void addLinhasHistorico(Usuario usuario, JTable tabela){
            String user = usuario.getUsuario();
            DefaultTableModel resultado_busca = (DefaultTableModel) tabela.getModel();
            resultado_busca.setRowCount(0); // limpa a tabela

            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                UsuarioDAO dao = new UsuarioDAO(conn);
                ResultSet res = dao.consultarHistorico(usuario);

                int cont = 0;
                while(res.next()){
                    String search = res.getString(1);
                    String filtro = res.getString(2);
                    
                    resultado_busca.addRow(new Object[] {
                        search, filtro
                    });
                }
            } catch(SQLException e){ 
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                                              "Erro de conexão!\n" + e.getMessage(), 
                                              "Aviso",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
    }