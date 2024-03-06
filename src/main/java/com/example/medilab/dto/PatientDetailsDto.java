package com.example.medilab.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDetailsDto {
    private String patientName;
    private String patientCode;
    private String gender;
    private String referredBy;
    private String age;
    private String testName;
    private String clinicalNotes;
    private LocalDateTime dateAndTime;
    private LocalDate issueDate;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PatientDetailsDto that = (PatientDetailsDto) o;
//        return Objects.equals(patientName, that.patientName);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(patientName, patientCode, gender, referredBy, age, testName, clinicalNotes, dateAndTime, issueDate);
    }
}
