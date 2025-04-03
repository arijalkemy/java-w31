package exerciseRaceEstructuraDinamica;

import java.lang.classfile.instruction.SwitchCase;

public class Inscription {
    public int numInscription;
    private double amount;
   // public int typeCircuit;
    Category category;
    Participant participant;

    public Inscription(int numInscription,Category category, Participant participant) {
        this.numInscription = numInscription;
        this.category = category;
        this.participant = participant;

    }

    public double getAmount() {

        switch (this.category.idCategory) {
            case 0:
            default:
                if (participant.getAge() < 18) {
                    amount = 1300.00;
                    return amount;
                } else {
                    amount = 1500.00;
                    return amount;
                }

            case 1:
                if (participant.getAge() < 18) {
                    amount = 2000.00;
                    return amount;
                } else {
                    amount = 2300.00;
                    return amount;
                }
            case 2:
                amount = 2800.00;
                return amount;

        }

    }

}
