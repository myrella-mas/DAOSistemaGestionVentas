
package dao.to;

import java.util.Date;

/**
 *
 * @author nikol
 */


public class VentaTO 
{
   private String CodVenta;
   private String Descripcion;
   private Double Monto;
   private Date Fecha;
   public String codPedido;
   
   /**
   @roseuid 5DD2B4EF0138
    */
   public VentaTO() 
   {
    
   }

    public String getCodVenta() {
        return CodVenta;
    }

    public void setCodVenta(String CodVenta) {
        this.CodVenta = CodVenta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }
   
   /**
   @param CodigoPedido
   @roseuid 5DD1998902E4
    */
   public void PagarPedido(int CodigoPedido) 
   {
    
   }
   
   /**
   @param dia
   @roseuid 5DD1B0CA01E0
    */
   public void ObtenerVentasXDia(int dia) 
   {
    
   }
   
   /**
   @param mes
   @roseuid 5DD1B0EA0314
    */
   public void ObtenerVentasxMes(int mes) 
   {
    
   }
   
   /**
   @param anio
   @roseuid 5DD1B10E02C9
    */
   public void ObtenerVentasXAnio(int anio) 
   {
    
   }
}
