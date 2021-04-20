/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.design.IPromocionDAO;
import dao.ds.BDRelacionalDAOFactory;
import dao.to.PromocionTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class BDRelacionalPromocionDAO implements IPromocionDAO{
  
    private final BDRelacionalDAOFactory db;
    
    public BDRelacionalPromocionDAO() {
        db = new BDRelacionalDAOFactory();
    }
    
    public String insertarPromocion(PromocionTO promocion) {
        String resp = null;
        Connection cn = db.getConnection();
        System.out.println(cn);
        String procedimientoAlmacenado = "INSERT INTO PROMOCION VALUES (?,?,?,?,?,?)";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(1, promocion.getCodigo());
                cs.setString(2, promocion.getCodProducto());
                cs.setString(3, promocion.getNombre());
                cs.setString(4, promocion.getDescripcion());
                cs.setInt(5, promocion.getCantidad()); 
                cs.setDouble(6,promocion.getCosto());
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Promocion Añadido");
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

    public List<PromocionTO> listarPromocion() {
        List<PromocionTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM PROMOCION";

        if (cn != null) {
            try {
                lista = new ArrayList();             
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    PromocionTO promocion = new PromocionTO();
                    promocion.setCodigo(rs.getString(1));
                    //promocion.setCodProducto(rs.getString(2));
                    promocion.setNombre(rs.getString(2));
                    promocion.setDescripcion(rs.getString(3));
                    promocion.setCantidad(rs.getInt(4)); 
                    //promocion.setCosto(rs.getDouble(6));
                    lista.add(promocion);
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

    public String actualizarPromocion(PromocionTO promocion){
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado = "UPDATE PROMOCION Set PRODUCTO_ID=?"
                + "Nombre  = ?, Descripcion  = ?,Cantidad  =?, Costo=? WHERE PROMOCION_ID =?" ;

        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(1, promocion.getCodigo()); 
                cs.setString(2, promocion.getCodProducto());
                cs.setString(3, promocion.getNombre());
                cs.setString(4, promocion.getDescripcion());
                cs.setInt(5, promocion.getCantidad()); 
                cs.setDouble(6, promocion.getCosto());
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ingreso a Promocion Correcto");

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

    public String eliminarPromocion(String codigoProm) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ResultSet rs;
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "DELETE FROM PROMOCION WHERE Promocion_ID  = ?";
        
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, codigoProm);

                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Promocion eliminado");

                if (insertado == 0) {
                    resp = "Error";
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Validación de datos", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Validación de datos", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        return resp;
    }

    public PromocionTO obtenerPromocion(String promocion_id) {
        PromocionTO promocion = new PromocionTO();
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM PROMOCION WHERE PROMOCION_ID  = ?";
        if (cn != null) {
            try {
            
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, promocion_id);
                rs = cs.executeQuery();

                if (rs.next()) {
                    promocion.setCodigo(rs.getString(1));
                    promocion.setCodProducto(rs.getString(2));
                    promocion.setNombre(rs.getString(3));
                    promocion.setDescripcion(rs.getString(4));
                    promocion.setCantidad(rs.getInt(5)); 
                    promocion.setCosto(rs.getDouble(6));                                     
                }
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

        return promocion;
    }
    
     public List<PromocionTO> listarPromocionCodigo() {
        List<PromocionTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT Promocion_ID  FROM PROMOCION";

        if (cn != null) {
            try {
                lista = new ArrayList();
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    PromocionTO cli = new PromocionTO();
                    cli.setCodigo(rs.getString(1));
                    lista.add(cli);
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
}
