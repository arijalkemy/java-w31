package com.meli.maolaya.crudjpa.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String code;
    private String type;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bug_reproducibility_details_id", referencedColumnName = "id")
    private BugReproducibilityDetails bugReproducibilityDetails;
    @ManyToMany(mappedBy = "bugs")
    private List<TestCase> testCases;
}
