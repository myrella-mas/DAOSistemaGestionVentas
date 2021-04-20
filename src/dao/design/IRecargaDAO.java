/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.RecargaTO;
import dao.to.TarjetaTO;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IRecargaDAO {
    public abstract String insertarRecarga(RecargaTO recarga);
    
}
