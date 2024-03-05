package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import springfox.documentation.spring.web.json.Json;

import java.time.LocalDate;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TestReportEntry {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String result;
    private String note;
    private LocalDate issueDate;
    private Integer modifiedCount;
    private String status;
    @OneToOne
    private AppointmentTest appointmentTest;
}
