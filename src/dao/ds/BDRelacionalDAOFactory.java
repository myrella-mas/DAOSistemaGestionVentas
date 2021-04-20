/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.ds;

import dao.DAOFactory;
import dao.component.BDNoSqlProductoDAO;
import dao.component.BDRelacionalProductoDAO;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oscar
 */
public class BDRelacionalDAOFactory extends DAOFactory {
    // public static final String url = "jdbc:oracle:thin:@sistemagestorventas.cabmg5th6ssj.us-east-1.rds.amazonaws.com:1521:DATABASE";
    // public static final String usuario = "admin";
    // public static final String contraseña = "nehil123";
    public static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    public static final String usuario = "KATTY";
    public static final String contraseña = "KATTY";

   public BDRelacionalDAOFactory() {
    }
   
    public Connection getConnection() {
        Connection cn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            cn = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println(cn);
            //JOptionPane.showMessageDialog(null,"Conexion Realizada con exito","Conexion a la BD",JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            JOptionPane.showMessageDialog(null,ex,"Error de la BD",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(BDRelacionalDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    @Override
    public BDRelacionalProductoDAO getProductoDAO() {
        return new BDRelacionalProductoDAO();
    }

    @Override
    public BDNoSqlProductoDAO getProductoDAO2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        
        BDRelacionalDAOFactory d = new BDRelacionalDAOFactory();
        d.getConnection();
    }
    
}
