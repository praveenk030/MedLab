package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tb_test_report_entry")
public class TestReport {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "note")
    private String note;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "modified_counts")
    private Integer modifiedCount;
    @Column(name = "status_P_d")
    private String status;
    @JoinColumn(name = "appointment_test_id")
    @OneToOne(mappedBy = "testReport")
    private AppointmentTest appointmentTest;
    @OneToMany(mappedBy = "testReport")
    private List<TestReportEntry> testReportEntries;
}
