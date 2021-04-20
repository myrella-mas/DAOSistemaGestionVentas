/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;
import dao.to.TarjetaTO;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ITarjetaDAO {
    
    public abstract String insertarTarjeta(TarjetaTO tarjeta);
    public abstract String eliminarTarjeta(String idTarjeta);
    public abstract List<String[]> listaTarjeta();
    
    public abstract  List<TarjetaTO> listarTarjetaCodigo();
    
    
}
