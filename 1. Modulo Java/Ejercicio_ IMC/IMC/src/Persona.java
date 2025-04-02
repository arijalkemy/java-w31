public class Persona {

    private String name;
    private Integer age;
    private String dni;
    private Double  weight;
    private Double height;

    public Persona(){}

    public Persona(String name, Integer age, String dni){
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, Integer age, String dni, Double weight, Double height){
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calculateIMC(){
        int result;
        double imc = (weight/(Math.pow(height, 2)));
        if(imc < 20){
            result =  -1;
        }else if(imc <= 25){
            result =  0;
        }else{
            result = 1;
        }
        return result;
    }

    public Boolean isLegaAge(){
        return age >= 18;
    }

    public String toString() {
        return "Persona {" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", dni='" + dni + '\'' +
               ", weight=" + weight +
               ", height=" + height +
               '}';
    }


    
}