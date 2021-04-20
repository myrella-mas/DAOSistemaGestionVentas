/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.ClienteTO;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IClienteDAO {
    public abstract String insertarCliente(ClienteTO cliente);
    public abstract List<ClienteTO> listarClientes();
    public abstract String actualizarCliente(ClienteTO cliente);
    public abstract String eliminarCliente(String nroCuenta);
    public abstract ClienteTO obtenerCliente(String cliente_id);
    public abstract List<ClienteTO> listarClientesCodigo();
}
