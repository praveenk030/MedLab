package com.example.medilab.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RecordDto {

	private String patientName;
	private String patientCode;
	private String gender;
	private String referredBy;
	private String age;
	private String testName;
	private String variablesName;
	private String units;
	private String referenceValue;
	private String results;
	private String clinicalNotes;
	private LocalDateTime dateAndTime;
	private LocalDate issueDate;

}
