class Sueldo {
    public static void main(String[] args) {
        double sueldoBase = 50000; //monto de ejemplo
        // String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;
        
        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase + ((sueldoBase * 20) / 100);
        }
        else {
          if (sueldoBase > 20000 && sueldoBase <= 45000){
              sueldoConAumento = sueldoBase + ((sueldoBase * 10) / 100);
          }
          else {
              sueldoConAumento = sueldoBase + ((sueldoBase * 5) / 100);
          }
        }
        
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}