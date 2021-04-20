/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

import java.util.Date;

/**
 *
 * @author nikol
 */
public class TarjetaTO {


   private String codTarjeta;
   private String nroCuenta;
   private Date FechaVencimiento;
   private Double Saldo;

    public TarjetaTO() {
    }

   
    public TarjetaTO(String codTarjeta, String nroCuenta, Date FechaVencimiento, Double Saldo) {
        this.codTarjeta = codTarjeta;
        this.nroCuenta = nroCuenta;
        this.FechaVencimiento = FechaVencimiento;
        this.Saldo = Saldo;
    }

    public String getCodTarjeta() {
        return codTarjeta;
    }

    public void setCodTarjeta(String codTarjeta) {
        this.codTarjeta = codTarjeta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }
  
   public void RecargarTarjeta(int CodigoTarjeta, int Monto) 
   {
       
   }
   
   /**
   @param CodigoTarjeta
   @param Monto
   @roseuid 5DD19DDB03E6
    */
   public void ValidarSaldo(int CodigoTarjeta, int Monto) 
   {
    
   }
   
   /**
   @param CodigoTarjeta
   @param Monto
   @roseuid 5DD1A569010E
    */
   public void DescontarSaldo(int CodigoTarjeta, int Monto) 
   {
    
   }
   
   /**
   @roseuid 5DD1C52C008C
    */
   public void ConsultaSaldo() 
   {
    
   }
           
      
}
