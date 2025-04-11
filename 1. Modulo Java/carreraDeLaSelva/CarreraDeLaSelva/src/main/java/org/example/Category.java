package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Category {

    private String id;
    private String name;
    private String description;
    private Integer collected;
    private final List<Participant> participantList;

    public Category(String id, String name, String description ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.collected = 0;
        participantList = new ArrayList<Participant>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Participant> getParticipantList() {
        return participantList;
    }

    public Integer getCollected() {
        return collected;
    }

    public void addParticipantList(Participant participant, int collected) {
        if (!participant.isRegisterParticipant()) {
            this.collected += collected;
            this.participantList.add(participant);
            participant.setRegisterParticipant(true);
        }
    }

    public void removeParticipantList(Participant participant, int collected) {
        if (participant.isRegisterParticipant()) {
            this.collected -= collected;
            this.participantList.remove(participant);
            participant.setRegisterParticipant(false);
        }
    }

    @Override
    public String toString() {
        return "Category "+ this.name + "\n" +
                participantList.stream()
                .map(Participant::toString)
                .collect(Collectors.joining("\n")) +
                "\n";
    }

    public String getCollectedString() {
        return "Categoria: "+ this.name + "\ntotal recogido: " + collected.toString() + "\n";
    }


}
