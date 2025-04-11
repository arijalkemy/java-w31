package org.example;

public class Inscription {
    private String id;
    private Participant participant;
    private Category category;
    private Integer payment;

    public Inscription(String id, Participant participant, Category category) {
        this.id = id;
        this.participant = participant;
        this.category = category;
        registerParticipant();
    }

    public String getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public Integer getPayment() {
        return payment;
    }

    public void unsubscribeParticipant() {
        this.category.removeParticipantList(this.participant,this.payment);
    }

    private void registerParticipant() {
        int registrationCost = registrationCostByCategory();;
            if(registrationCost != -1) {
                this.payment = registrationCost;
                this.category.addParticipantList(this.participant,registrationCost);
            }else {
                System.out.println("El participante " + this.participant.getName() + " no tiene la edad suficiente.");
            }
    }

    private int registrationCostByCategory(){
        int registrationCost = -1;
        String categoryName = this.category.getName().toLowerCase();
        if(categoryName.contains("small")){
            registrationCost = (this.participant.getAge() <  18) ? 1300 : 1500;
        }
        else if(categoryName.contains("medium")) {
            registrationCost = (participant.getAge() <  18) ? 2000 : 2300;
        }else if (categoryName.contains("large")) {
            registrationCost = (participant.getAge() <  18) ? registrationCost : 2800;
        }
        return registrationCost;
    };
}
