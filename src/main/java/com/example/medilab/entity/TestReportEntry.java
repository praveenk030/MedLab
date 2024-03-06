package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @Column(name = "test_group_details_id")
    private String testGtGroupDetailsId;
    @JoinColumn(name = "test_report_id")
    @ManyToOne
    private TestReport testReport;
}
