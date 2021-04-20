/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ds;

import dao.component.BDNoSqlProductoDAO;
import dao.component.BDRelacionalProductoDAO;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import dao.DAOFactory;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class BDNoSqlDAOFactory extends DAOFactory {

    public static final String url = "jdbc:mongodb+srv://marco:<123>@cluster0-067bg.mongodb.net/test?retryWrites=true&w=majority//Minimarket";
  
    public static final String usuario = "marco";
    public static final String contraseña = "123";
    public static Statement stat=null;
    PreparedStatement pstmt=null;
    private ResultSet resultado=null;
    
    public BDNoSqlDAOFactory() {
    }

    public static Connection getConnection() {
        Connection c=null;

        try {
            Class.forName("com.mongodb.Driver");
            c=DriverManager.getConnection(url,usuario,contraseña);
            stat = c.createStatement();
            c.setAutoCommit(false);
            stat.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error de la BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BDNoSqlDAOFactory.class.getName()).log(Level.SEVERE, null, e);
            System.exit(0);
        }
        return c;
    }

    

   
    
  
    @Override
    public BDNoSqlProductoDAO getProductoDAO2() {
        return new BDNoSqlProductoDAO();
    }

    @Override
    public BDRelacionalProductoDAO getProductoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
