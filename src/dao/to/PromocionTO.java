package dao.to;

/**
 *
 * @author nikol
 */


public class PromocionTO
{
   private String Codigo;
   private String CodProducto;
   private String Nombre;
   private String Descripcion;
   private Integer Cantidad;
   private Double Costo;

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getCodProducto() {
        return CodProducto;
    }

    public void setCodProducto(String CodProducto) {
        this.CodProducto = CodProducto;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }
   
   
   /**
   @roseuid 5DD19832038B
    */
   public PromocionTO() 
   {
    
   }
   
   /**
   @param Codigo
   @param Nombre
   @param Descripcion
   @param Cantidad
   @param Costo
   @roseuid 5D8858F700A8
    */
   public void AñadirPromocion(int Codigo, int Nombre, int Descripcion, int Cantidad, int Costo) 
   {
    
   }
   
   /**
   @param Codigo
   @param Nombre
   @param Descripcion
   @param Cantidad
   @param Costo
   @roseuid 5D8859070230
    */
   public void setPromocion(int Codigo, int Nombre, int Descripcion, int Cantidad, int Costo) 
   {
    
   }
   
   /**
   @param Codigo
   @roseuid 5D88590D00A8
    */
   public void EliminarPromocion(int Codigo) 
   {
    
   }
   
   /**
   @param Codigo
   @roseuid 5DC3650102F2
    */
   public void BuscarPromocion(int Codigo) 
   {
    
   }
}
