package bootcamp.temperaturas;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {

                String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisbon", "Tokio"};
            int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
            int max = temperaturas[0][1];
            int min = temperaturas[0][0];
            int indiceMax = 0;
            int indiceMin = 0;
            for (int i = 0; i < temperaturas.length; i++) {
                for (int j = 0; j < temperaturas[i].length; j++) {
                    if(temperaturas[i][j] > max){
                        max = temperaturas[i][j];
                        indiceMax = i;
                    } else if(temperaturas[i][j] < min){
                        min = temperaturas[i][j];
                        indiceMin = i;
                    }
                }
            }
            System.out.println("Temperatura maxima " + max + " fue en " +ciudades[indiceMax]);
            System.out.println("Temperatura minima " + min + " fue en " +ciudades[indiceMin]);
    }
}