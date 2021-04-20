/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

/**
 *
 * @author nikol
 */
import dao.ds.BDRelacionalDAOFactory;
import dao.design.IClienteDAO;
import dao.to.ClienteTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class BDRelacionalClienteDAO implements IClienteDAO {

    private final BDRelacionalDAOFactory db;

    public BDRelacionalClienteDAO() {
        db = new BDRelacionalDAOFactory();
    }

    @Override
    public String insertarCliente(ClienteTO cliente) {
        String resp = null;
        Connection cn = db.getConnection();
        System.out.println(cn);
        String procedimientoAlmacenado = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?)";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(1, cliente.getNroCuenta());
                cs.setString(2, cliente.getNombre());
                cs.setString(3, cliente.getApellido());
                cs.setInt(4, cliente.getDNI());
                cs.setInt(5, cliente.getTelefono());
                cs.setInt(6, cliente.getEdad());
                cs.setString(7, cliente.getEmail());
                cs.setString(8, cliente.getDireccion());
                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente Añadido");
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

    public List<ClienteTO> listarClientes() {
        List<ClienteTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM CLIENTE";

        if (cn != null) {
            try {
                lista = new ArrayList();
                //Lectura de Cobertura
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    ClienteTO cli = new ClienteTO();
                    cli.setNroCuenta(rs.getString(1));
                    cli.setNombre(rs.getString(2));
                    cli.setApellido(rs.getString(3));
                    cli.setDNI(rs.getInt(4));
                    cli.setTelefono(rs.getInt(5));
                    cli.setEdad(rs.getInt(6));
                    cli.setEmail(rs.getString(7));
                    cli.setDireccion(rs.getString(8));
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

    public String actualizarCliente(ClienteTO cliente){
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado = "UPDATE CLIENTE Set "
                + " NOMBRE = ?, APELLIDO = ?, DNI = ?,TELEFONO = ?,"
                + "EDAD = ?,EMAIL = ?,DIRECCION = ? WHERE CLIENTE_ID=?" ;

        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado);
                cs.setString(8, cliente.getNroCuenta());
                cs.setString(1, cliente.getNombre());
                cs.setString(2, cliente.getApellido());
                cs.setInt(3, cliente.getDNI());
                cs.setInt(4, cliente.getTelefono());
                cs.setInt(5, cliente.getEdad());
                cs.setString(6, cliente.getEmail());
                cs.setString(7, cliente.getDireccion());

                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Ingreso a Clientes Correcto");

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

    public String eliminarCliente(String nroCuenta) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ResultSet rs;
        String resp = null;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "DELETE FROM CLIENTE WHERE CLIENTE_ID = ?";
        
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, nroCuenta);

                int insertado = cs.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente eliminado");

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

    public ClienteTO obtenerCliente(String cliente_id) {
        ClienteTO cliente = new ClienteTO();
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT * FROM CLIENTE WHERE CLIENTE_ID = ?";
        if (cn != null) {
            try {
            
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                cs.setString(1, cliente_id);
                rs = cs.executeQuery();

                if (rs.next()) {
                    cliente.setNroCuenta(rs.getString(1));
                    cliente.setNombre(rs.getString(2));
                    cliente.setApellido(rs.getString(3));
                    cliente.setDNI(rs.getInt(4));
                    cliente.setTelefono(rs.getInt(5));
                    cliente.setEdad(rs.getInt(6));
                    cliente.setEmail(rs.getString(7));
                    cliente.setDireccion(rs.getString(8));            
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

        return cliente;
    }
    
     public List<ClienteTO> listarClientesCodigo() {
        List<ClienteTO> lista = null;
        ResultSet rs;
        Connection cn = db.getConnection();
        String procedimientoAlmacenado01 = "SELECT CLIENTE_ID FROM CLIENTE";

        if (cn != null) {
            try {
                lista = new ArrayList();
                //Lectura de Cobertura
                CallableStatement cs = cn.prepareCall(procedimientoAlmacenado01);
                rs = cs.executeQuery();

                while (rs.next()) {
                    ClienteTO cli = new ClienteTO();
                    cli.setNroCuenta(rs.getString(1));
                    
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
