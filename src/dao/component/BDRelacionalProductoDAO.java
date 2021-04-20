/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.ds.BDRelacionalDAOFactory;
import dao.design.IProductoDAO;
import dao.to.ProductoTO;
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
public class BDRelacionalProductoDAO implements IProductoDAO{
   
    private final BDRelacionalDAOFactory db;
    
    public BDRelacionalProductoDAO() {
       
       db=new BDRelacionalDAOFactory();
        
    }

    @Override
    public String insertarProducto(ProductoTO producto) {
        String resp = null;
        //Connection cn = db.getConnection();
        Connection cn = db.getConnection();
        System.out.println(cn);
        String procedimientoAlmacenado = "INSERT INTO PRODUCTO VALUES (?,?,?,?,?)";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(1, producto.getCodigo());  
                cs.setString(2, producto.getNombre());
                cs.setString(3, producto.getDescripción());
                cs.setInt(4, producto.getCantidad());
                cs.setDouble(5, producto.getCosto());
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Producto Añadido");
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

    @Override
    public List<ProductoTO> listarProducto() {
        List<ProductoTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        System.out.println(cn);
        String procedimientoAlmacenado01 = "SELECT * FROM PRODUCTO";

        if (cn != null) {
            try {
                lista = new ArrayList();             
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    ProductoTO producto = new ProductoTO();
                    producto.setCodigo(rs.getString(1));
                    producto.setNombre(rs.getString(2));
                    producto.setDescripción(rs.getString(3));
                    producto.setCantidad(rs.getInt(4));
                    producto.setCosto(rs.getDouble(5));
                    lista.add(producto);
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

    @Override
    public String actualizarProducto(ProductoTO cliente){
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado = "UPDATE PRODUCTO Set "
                + "Nombre  = ?, Descripcion  = ?,Cantidad  = ?,Costo  = ? WHERE PRODUCTO_ID =?" ;

        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(5, cliente.getCodigo());            
                cs.setString(1, cliente.getNombre());
                cs.setString(2, cliente.getDescripción());
                cs.setInt(3, cliente.getCantidad());
                cs.setDouble(4, cliente.getCosto());
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ingreso a Producto Correcto");

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

    @Override
    public String eliminarProducto(String codigoProd) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ResultSet rs;
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "DELETE FROM PRODUCTO WHERE Producto_ID  = ?";
        
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, codigoProd);

                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Producto eliminado");

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

    @Override
    public ProductoTO obtenerProducto(String producto_id) {
        ProductoTO producto = new ProductoTO();
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM PRODUCTO WHERE Producto_ID  = ?";
        if (cn != null) {
            try {
            
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, producto_id);
                rs = cs.executeQuery();

                if (rs.next()) {
                    producto.setCodigo(rs.getString(1));                 
                    producto.setNombre(rs.getString(2));
                    producto.setDescripción(rs.getString(3));
                    producto.setCantidad(rs.getInt(4));
                    producto.setCosto(rs.getDouble(5));
                        
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

        return producto;
    }
    
    @Override
     public List<ProductoTO> listarProductosCodigo() {
        List<ProductoTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT Producto_ID  FROM PRODUCTO";

        if (cn != null) {
            try {
                lista = new ArrayList();
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    ProductoTO cli = new ProductoTO();
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
     
     
      public List<ProductoTO> listarProductoMenorDiez() {
        List<ProductoTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM PRODUCTO WHERE CANTIDAD <= 10";

        if (cn != null) {
            try {
                lista = new ArrayList();             
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    ProductoTO producto = new ProductoTO();
                    producto.setCodigo(rs.getString(1));
                    producto.setNombre(rs.getString(2));
                    producto.setDescripción(rs.getString(3));
                    producto.setCantidad(rs.getInt(4));
                    producto.setCosto(rs.getDouble(5));
                    lista.add(producto);
                }

               
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
