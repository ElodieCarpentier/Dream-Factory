
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kévin
 */
public class ConnectionBDD {
    
    public static void sauverenBase(String personne, String psswd,String status){
        String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        Connection cn= null;
        Statement st=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            String sql="Insert into `user` (`ID_USER`, `PWD`,`STATUT`) VALUES('"+ personne +"','"+ psswd +"','"+ status +"')";
            
            st.executeUpdate(sql);
        }
            catch (SQLException e){
                    e.printStackTrace();
            }
            catch (ClassNotFoundException e){
                    e.printStackTrace();
            }
            finally {
                    try{
                        cn.close();
                        st.close();
                    } catch(SQLException e){
                    e.printStackTrace();
                    } 
            }
    }
    
    public static void lireenbase(){
      String url = "jdbc:mysql://localhost/dreamfactory";
        String login= "root";
        String passwd="";
        Connection cn= null;
        Statement st=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            String sql = "Select ID_USER from `user`";
            rs=st.executeQuery(sql);
            
            while (rs.next())
            {
               System.out.println(rs);
            }
                   
            
        }
            catch (SQLException e){
                    e.printStackTrace();
            }
            catch (ClassNotFoundException e){
                    e.printStackTrace();
            }
            finally {
                    try{
                        cn.close();
                        st.close();
                    } catch(SQLException e){
                    e.printStackTrace();
                    } 
            }
                 
    }
}