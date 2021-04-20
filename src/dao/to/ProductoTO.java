package dao.to;

/**
 *
 * @author nikol
 */

public class ProductoTO 
{
   private String Codigo; 
   private String Nombre;
   private String Descripción;
   private Integer Cantidad;
   private Double Costo;
   
   /**
   @roseuid 5DD1983200C0
    */
   public ProductoTO() 
   {
    
   }

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

    public String getDescripción() {
        return Descripción;
    }

    public void setDescripción(String Descripción) {
        this.Descripción = Descripción;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
        this.Costo = Costo;
    }
   
   
   
   /**
   @param Codigo
   @param Nombre
   @param Descripcion
   @param Costo
   @param Cantidad
   @roseuid 5DCF96C303B8
    */
   public void AñadirProducto(int Codigo, int Nombre, int Descripcion, int Costo, int Cantidad) 
   {
    
   }
   
   /**
   @param Codigo
   @param Nombre
   @param Descripcion
   @param Costo
   @param Cantidad
   @roseuid 5D87E0CA003F
    */
   public void ModificarDatos(int Codigo, int Nombre, int Descripcion, int Costo, int Cantidad) 
   {
    
   }
   
   /**
   @param Codigo
   @roseuid 5D87E0D200D3
    */
   public void EliminarProducto(int Codigo) 
   {
    
   }
   
   /**
   @param Codigo
   @roseuid 5DCF93F00290
    */
   public void BuscarStock(int Codigo) 
   {
    
   }
   
   /**
   @roseuid 5D87E0BE0107
    */
   public void ObtenerDatosProducto() 
   {
    
   }
}
