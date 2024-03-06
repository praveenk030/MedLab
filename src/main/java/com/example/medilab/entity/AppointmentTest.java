package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tb_appointment_test")
public class AppointmentTest {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name ="id" )
    private String id;
    @Column(name ="tube_no" )
    private String tubeNo;
    @Column(name = "collected_by")
    private String collectedBy;
    @Column(name = "test_status")
    private  String status;
    @JoinColumn(name = "test_group_id")
    @ManyToOne
    private TestGroup testGroup;
    @JoinColumn(name ="appointment_id" )
    @ManyToOne
    private Appointment appointments;
    @OneToOne(mappedBy = "appointmentTest")
    private TestReportEntry testReportEntry;

}
