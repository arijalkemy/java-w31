package exerciseRaceEstructuraDinamica;

public class Participant {
    private int numParticipant;
    private int dni;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private int numEmergency;
    private String bloodType;

    

    public Participant(int numParticipant, int dni, String firstName, String lastName, int age, String phone,
            int numEmergency, String bloodType) {
        this.numParticipant = numParticipant;
        this.dni = dni;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.numEmergency = numEmergency;
        this.bloodType = bloodType;
    }

    public int getNumParticipant() {
        return this.numParticipant;
    }

    public void setNumParticipant(int numParticipant) {
        this.numParticipant = numParticipant;
    }

    public int getDni() {
        return this.dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNuEmergency() {
        return this.numEmergency ;
    }

    public void setNumEmergency(int numEmergency) {
        this.numEmergency = numEmergency;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

}
