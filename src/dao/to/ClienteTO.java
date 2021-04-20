package dao.to;
/**
 *
 * @author nikol
 */

/**
Los clientes solo usan tarjeta
 */
public class ClienteTO 
{
   private String NroCuenta;
   private String Nombre;
   private String Apellido;
   private Integer DNI;
   private Integer Edad;
   private String Direccion;
   private Integer Telefono;
   private String Email;
   
   
   /**
   @roseuid 5DD198320276
    */
   public ClienteTO() 
   {
    
   }

    public ClienteTO(String NroCuenta, String Nombre, String Apellido, Integer DNI, Integer Edad, String Direccion, Integer Telefono, String Email) {
        
        this.NroCuenta=NroCuenta;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Edad = Edad;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Email = Email;
        
    }

    public String getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(String NroCuenta) {
        this.NroCuenta=NroCuenta;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public Integer getTelefono() {
        return Telefono;
    }

    public void setTelefono(Integer Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

//    public Tarjeta getTheTarjeta() {
//        return theTarjeta;
//    }

//    public void setTheTarjeta(Tarjeta theTarjeta) {
//        this.theTarjeta = theTarjeta;
//    }
//
//    public Promoción getThePromoción() {
//        return thePromoción;
//    }
//
//    public void setThePromoción(Promoción thePromoción) {
//        this.thePromoción = thePromoción;
//    }

  
   
 
   /**
   @param NroCuenta
   @param DNI
   @param Nombre
   @param etc.
   @roseuid 5DCF91DE0088
    */
   public void AñadirCliente(String NroCuenta, int Nombre, int Apellido, int DNI, int edad, int direccion, int telefono, int email) 
   {
    
   }
   
   /**
   @param NroCuenta
   @param Nombre
   @param Apellido
   @param DNI
   @param edad
   @param direccion
   @param telefono
   @param email
   @roseuid 5DCF91F80211
    */
   public void setCliente(int NroCuenta, int Nombre, int Apellido, int DNI, int edad, int direccion, int telefono, int email) 
   {
    
   }
   
   /**
   @param NroCuenta
   @roseuid 5DCF91FA014E
    */
   public void EliminarCliente(int NroCuenta) 
   {
    
   }
   
   /**
   @param NroCuenta
   @roseuid 5DCF921700F8
    */
   public void BuscarCliente(int NroCuenta) 
   {
    
   }

    public boolean validaTarjeta(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}
