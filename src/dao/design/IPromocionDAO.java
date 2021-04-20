/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.PromocionTO;
import java.util.List;

/**
 *
 * @author pc
 */
public interface IPromocionDAO {
    public abstract String insertarPromocion(PromocionTO promocion);
    public abstract List<PromocionTO> listarPromocion();
    public abstract String actualizarPromocion(PromocionTO promocion);
    public abstract String eliminarPromocion(String codigoProm) ;
    public abstract PromocionTO obtenerPromocion(String promocion_id);
    public abstract List<PromocionTO> listarPromocionCodigo() ;
    
}
