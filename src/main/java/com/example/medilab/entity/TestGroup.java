package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestGroup {
    @Id
    private String id;
    private String name;
    @ManyToOne
    private SpecimenType specimenType;
    @JoinColumn
    @OneToMany(mappedBy = "testGroup")
    private List<TestGroupDetails> testGroupDetails;
}
