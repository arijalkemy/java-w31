package exerciseInterface.punto3.clases;

import exerciseInterface.punto3.interfaz.AlimentacionHervibora;

public class Vaca extends Animal implements AlimentacionHervibora{

    @Override
    public void emitirsonido() {
       System.out.println(" Muuu");
    }

    @Override
    public void comehierba() {
    System.out.println(" La vaca es hervibora");  
    }

    @Override
    public void comer() {
      this.comehierba();
    }
    
}
