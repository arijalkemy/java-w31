package meliJava;

public class EmpresaSeguridad {
	public static void main(String[] args) {
		int [] serviciosCli = {1,2,1,1,2,2,1}; //vector de 7 posiciones con tipos de servicios
		int totalFactura = 1500;
		int cliente = 1;
		
		for (int i = 0; i<serviciosCli.length;i++) {
			System.out.println ("-- Cliente: " +cliente+" --");
			 cliente = cliente + 1;
		  if (serviciosCli[i]== 1) {
		     System.out.println ("El tipo de servicio es de camaras");
		     System.out.println ("El monto de la factura es de: " + totalFactura);
		  }
		  else {
		     System.out.println ("El tipo de servicio es de camaras y patrullaje");
		     System.out.println ("El monto de la factura es de: " + (totalFactura+700));

		  }
		}

	} 

}
