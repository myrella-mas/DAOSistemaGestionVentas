package dao.to;


import java.util.Date;

/**
 *
 * @author nikol
 */

public class ComprobanteDePagoTO 
{
   private String codComprobante;
   private Date Fecha;
   private String codVenta;
  
   
   /**
   @roseuid 5DD1983300BF
    */
   public ComprobanteDePagoTO() 
   {
    
   }
   
    public String getCodComprobante() {
        return codComprobante;
    }

    public void setCodComprobante(String CodComprobante) {
        this.codComprobante = CodComprobante;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }
    
    
 
   
   /**
   @roseuid 5D8867FE03A9
    */
   
   public void ObtenerComprobante(int codigoVenta) 
   {
    
   }
}
