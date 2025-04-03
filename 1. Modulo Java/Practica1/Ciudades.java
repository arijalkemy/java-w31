package Practica1;

public class Ciudades {

    public static void main (String[] args){
        String[] ciudades = new String[]{"Londres","Madrid","Nueva York","Buenos Aires","Asunción",	"São Paulo","Lima",	"Santiago de Chile","Lisboa","Tokio"} ;

        int [][] temperaturas = new int[10][2];
        temperaturas[0][0] = -2;
        temperaturas[0][1] = 33;

        temperaturas[1][0] = -3;
        temperaturas[1][1] = 32;

        temperaturas[2][0] = -8;
        temperaturas[2][1] = 27;

        temperaturas[3][0] = 4;
        temperaturas[3][1] = 37;

        temperaturas[4][0] = 6;
        temperaturas[4][1] = 42;

        temperaturas[5][0] = 5;
        temperaturas[5][1] = 43;

        temperaturas[6][0] = 0;
        temperaturas[6][1] = 39;

        temperaturas[7][0] = -7;
        temperaturas[7][1] = 26;

        temperaturas[8][0] = -1;
        temperaturas[8][1] = 31;

        temperaturas[9][0] = -10;
        temperaturas[9][1] = 35;

        int menorTemperaturaIndice = 0;
        int mayorTemperaturaIndice = 0;
        for(int i = 0 ; i< ciudades.length ; i++) {
            if( temperaturas[i][0] < temperaturas[menorTemperaturaIndice][0]) {
                menorTemperaturaIndice = i;
            }
            if( temperaturas[i][1] > temperaturas[mayorTemperaturaIndice][1]) {
                mayorTemperaturaIndice = i;
            }

        }

        System.out.println("ciudad con menor temperadura: " + ciudades[menorTemperaturaIndice]);
        System.out.println("ciudad con mayor temperadura: " + ciudades[mayorTemperaturaIndice]);


        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i  = 0;  i < serviciosCli.length; i++ ) {
            if (serviciosCli[i] ==1 ) {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura = 1500;
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                totalFactura = 2200;
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }

    }

}



