/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import dao.ds.BDNoSqlDAOFactory;
import dao.design.IProductoDAO;
import dao.to.ProductoTO;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nikol
 */
public class BDNoSqlProductoDAO implements IProductoDAO  {

    private final BDNoSqlDAOFactory db;
    DB db2;
    DBCollection producto;
    
    public BDNoSqlProductoDAO() {
        db=new BDNoSqlDAOFactory();
        Mongo mongo= new Mongo();
        db2=mongo.getDB("Minimarket");
        producto=db2.getCollection("Producto");
        
    }
    
    @Override
    public String insertarProducto(ProductoTO prod) {
        String resp=null;
        BasicDBObject document=new BasicDBObject();
        document.put("_id:"," "+prod.getCodigo()+" ");
        document.put("Nombre:"," "+prod.getNombre()+" ");
        document.put("Descripcion:"," "+prod.getDescripción()+" ");
        document.put("Cantidad:"," "+prod.getCantidad()+" ");
        document.put("Costo:"," "+prod.getCosto()+" ");
        producto.insert(document);
        return resp;
    }

    @Override
    public List<ProductoTO> listarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizarProducto(ProductoTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarProducto(String nroCuenta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoTO obtenerProducto(String cliente_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductoTO> listarProductosCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
