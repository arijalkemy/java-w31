package ejerciciouno.models;

import ejerciciouno.interfaces.IConsultaSaldo;
import ejerciciouno.interfaces.IPagoServicios;
import ejerciciouno.interfaces.IRetiroEfectivo;

public class Basico {
   private final IConsultaSaldo consultaSaldo;
   private final IPagoServicios pagoServicio;
   private final IRetiroEfectivo retiroEfectivo;

   public Basico(IConsultaSaldo consulta, IPagoServicios pagoServicio, IRetiroEfectivo retiroEfectivo) {
      System.out.println("\tBasico");
      this.consultaSaldo = consulta;
      this.pagoServicio = pagoServicio;
      this.retiroEfectivo = retiroEfectivo;
   }

   public void consultarSaldo() {
      this.consultaSaldo.consultarSaldo();
   }

   public void estadoConsultarSaldo() {
      this.consultaSaldo.transaccionOk();
   }

   public void pagarServicios(){
      this.pagoServicio.pagarServicios();
   }

   public void estadoPagarServicios() {
      this.pagoServicio.transaccionOk();
   }

   public void retirarEfectivo(){
      this.retiroEfectivo.retirarEfectivo();
   }

   public void estadoRetirarEfectivo() {
      this.retiroEfectivo.transaccionOk();
   }
}
