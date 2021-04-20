/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.ProductoTO;
import java.util.List;

/**
 *
 * @author Nikol
 */
public interface IProductoDAO {
    public abstract String insertarProducto(ProductoTO producto);
    public abstract List<ProductoTO> listarProducto();
    public abstract String actualizarProducto(ProductoTO producto);
    public abstract String eliminarProducto(String nroCuenta);
    public abstract ProductoTO obtenerProducto(String cliente_id);
    public abstract List<ProductoTO> listarProductosCodigo();
}
