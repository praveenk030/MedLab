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
@Table(name = "tb_test_report_entry")
public class TestReportEntry {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "result")
    private String result;
    @Column(name = "note")
    private String note;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "modified_counts")
    private Integer modifiedCount;
    @Column(name = "status_P_d")
    private String status;
    @JoinColumn(name = "appointment_test_id")
    @OneToOne(mappedBy = "testReportEntry")
    private AppointmentTest appointmentTest;
}
