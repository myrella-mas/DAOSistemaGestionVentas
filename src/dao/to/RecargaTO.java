package dao.to;

/**
 *
 * @author nikol
 */
public class RecargaTO {

    private String Codigo;
    private String CodigoTarjeta;
    private double Monto;

    /**
     * @roseuid 5DD2B4EF02C0
     */
    public RecargaTO() {

    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getCodigoTarjeta() {
        return CodigoTarjeta;
    }

    public void setCodigoTarjeta(String CodigoTarjeta) {
        this.CodigoTarjeta = CodigoTarjeta;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

   

    /**
     * @param CodigoTrajeta
     * @param Monto
     * @roseuid 5DD1A39F007A
     */
    public void RegistrarRecarga(int CodigoTajeta, int Monto) {
        

    }
}
