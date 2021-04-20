/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.design.ITarjetaDAO;
import dao.ds.BDRelacionalDAOFactory;
import dao.to.TarjetaTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author nikol
 */
public class BDRelacionalTarjetaDAO  implements ITarjetaDAO{

  
    private final BDRelacionalDAOFactory db;
      
    public BDRelacionalTarjetaDAO() {
        db=new BDRelacionalDAOFactory();
    }
    

    public String insertarTarjeta(TarjetaTO tarjeta) {
        
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado = "INSERT INTO TARJETA VALUES(?,?,?,?)";
     
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(1, tarjeta.getCodTarjeta());
                cs.setString(2, tarjeta.getNroCuenta());
                cs.setDate(3, new java.sql.Date(tarjeta.getFechaVencimiento().getTime()));
                cs.setDouble(4, tarjeta.getSaldo());

                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ingreso a Tarjeta Correcto");

                if (insertado == 0) {
                    resp = "Error";
                }
            } catch (SQLException ex) {
                System.out.println(ex.getErrorCode());
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Validación de datos", JOptionPane.WARNING_MESSAGE);
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

    public String eliminarTarjeta(String idTarjeta) {
        ResultSet rs;
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "DELETE FROM TARJETA WHERE Tarjeta_ID = ?";

        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, idTarjeta);
                
                int insertado = cs.executeUpdate();
               JOptionPane.showMessageDialog(null, "Tarjeta eliminada");
                
                if (insertado == 0) {
                    resp = "Error";
                }
              
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Validación de datos", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(), "Validación de datos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        return resp;
    }
  
    public List<String[]> listaTarjeta() { 
        List<String[]> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT c.Tarjeta_ID , u.Nombre,  u.Apellido,"
                + "c.FechaVencimiento, c.Saldo  FROM TARJETA c, CLIENTE u WHERE c.Cliente_ID  = u.Cliente_ID";
     
        if (cn != null) {
            try {
                lista = new ArrayList();
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();
                
                while (rs.next()) {
                    String[] arreglo = new String[5];
                    arreglo[0]=rs.getString(1);
                    arreglo[1]=rs.getString(2);
                    arreglo[2]=rs.getString(3);
                    arreglo[3]=rs.getString(4);
                    arreglo[4]=rs.getString(5);
                    lista.add(arreglo);
                }
                
                //JOptionPane.showMessageDialog(null, "Ingreso a Usuarios Correcto");
            } catch (SQLException ex) {
                //Logger.getLogger(CEstudiosDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    
                }
            }
        }
        System.out.println(lista);
        return lista;
    }
   
    public List<TarjetaTO> listarTarjetaCodigo() {
        List<TarjetaTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT Tarjeta_ID FROM TARJETA";

        if (cn != null) {
            try {
                lista = new ArrayList();
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    TarjetaTO tj = new TarjetaTO();
                    tj.setNroCuenta(rs.getString(1));
                    
                    lista.add(tj);
                }
                //JOptionPane.showMessageDialog(null, "Ingreso a Usuarios Correcto");
            } catch (SQLException ex) {
                //Logger.getLogger(CEstudiosDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {

                }
            }
        }
        System.out.println(lista);
        return lista;
    }
    
     public String actualizarTarjeta(Double saldo,String tarjetaId){
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado = "UPDATE TARJETA Set SALDO=? WHERE TARJETA_ID=?" ;

        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setDouble(1, saldo);
                cs.setString(2, tarjetaId);
             
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ingreso a Tarjeta Correcto");

                if (insertado == 0) {
                    resp = "Error";
                }
            } catch (SQLException ex) {
                System.out.println("F"+ex.getErrorCode());
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

    public TarjetaTO obtenerTarjeta(String nroTarjeta) {
        TarjetaTO tj = new TarjetaTO();
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM TARJETA WHERE TARJETA_ID = ?";
        
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, nroTarjeta);
                rs = cs.executeQuery();
                
                if (rs.next()) {
                   tj.setCodTarjeta(rs.getString(1));
                    tj.setNroCuenta(rs.getString(2));
                    tj.setFechaVencimiento(rs.getDate(3));
                    tj.setSaldo(rs.getDouble(4));
                  
                }

             //   JOptionPane.showMessageDialog(null, "Ingreso a Autores Correcto");
            } catch (SQLException ex) {
                //Logger.getLogger(CEstudiosDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.err.print(ex.getMessage());
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    
                }
            }
        }
        
        return tj;
    }

    
}
