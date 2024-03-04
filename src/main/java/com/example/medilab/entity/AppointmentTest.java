package com.example.medilab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppointmentTest {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String testGroupID;
    private String tubeNo;
    private String collectedBy;
    @OneToMany(mappedBy = "")
    private List<Appointment> appointments;

}
