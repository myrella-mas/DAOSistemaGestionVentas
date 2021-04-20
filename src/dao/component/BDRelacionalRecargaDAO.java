/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.design.IRecargaDAO;
import dao.ds.BDRelacionalDAOFactory;
import dao.to.RecargaTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class BDRelacionalRecargaDAO implements IRecargaDAO{
    
    private final BDRelacionalDAOFactory db;

    public BDRelacionalRecargaDAO() {
       db = new BDRelacionalDAOFactory();        
    }
    
    public String insertarRecarga(RecargaTO recarga){
         String resp = null;
        Connection cn = db.getConnection();
        System.out.println(cn);
        String procedimientoAlmacenado = "INSERT INTO RECARGA VALUES (?,?,?)";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(1, recarga.getCodigo());
                cs.setString(2, recarga.getCodigoTarjeta());
                cs.setDouble(3, recarga.getMonto());
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Recarga Añadido");
                if (insertado == 0) {
                    resp = "Error";
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Validación de datos", JOptionPane.WARNING_MESSAGE);
                //1400 (error por espacio null)
                //2290 (violacion de una restriccion)
                //0001 (llave repetida)
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return resp;
    }

  

}
