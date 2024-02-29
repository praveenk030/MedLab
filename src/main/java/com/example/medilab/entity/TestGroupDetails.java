package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TestGroupDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String variable;
    private String unit;
    private String referenceValue;
    @JoinColumn(name = "")
    @ManyToOne
    private TestGroup testGroup;
}
