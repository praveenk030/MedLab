package com.example.medilab.service;

import java.util.*;


import com.example.medilab.dto.PatientDetailsDto;
import com.example.medilab.dto.ResultDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.medilab.bean.MyRecord;
import com.example.medilab.dto.RecordDto;
import com.example.medilab.repository.ReportRep;
import com.lowagie.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReportRep recordRep;

    private final TemplateEngine templateEngine;

    private static final Logger LOG = LoggerFactory.getLogger(ReportService.class);

    public ReportService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(String templatePath, Map<String, Object> contextVariables)
            throws DocumentException, IOException {
        Context context = new Context();

        // Fetch data from the database
        // Convert MyRecord to RecordDto

        // Add the database data to the context
        // contextVariables.put("reportData", recordDto);
        context.setVariables(contextVariables);

        String html = templateEngine.process(templatePath, context);

        Path path = Files.createTempFile(UUID.randomUUID().toString(), ".pdf");
        try (OutputStream outputStream = Files.newOutputStream(path)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
        }
        LOG.debug("Wrote PDF file for template {}: {}", templatePath, path);
        byte[] bytes = Files.readAllBytes(path);
        Files.delete(path);
        return bytes;
    }


    private List<RecordDto> getMyRecordsDto(List<MyRecord> myRecordEntities) {
        List<RecordDto> recordDtoList = new ArrayList<>();
        for (MyRecord re : myRecordEntities) {
            RecordDto record= RecordDto.builder().patientName(re.getPatientName())
                    .patientCode(re.getPatientCode())
                    .age(re.getAge())
                    .gender(re.getGender())
                    .dateAndTime(re.getDateAndTime())
                    .clinicalNotes(re.getClinicalNotes())
                    .issueDate(re.getissueDate())
                    .referredBy(re.getReferredBy())
                    .referenceValue(re.getReferenceValue())
                    .testName(re.getTestName())
                    .units(re.getUnits())
                    .results(re.getResults())
                    .variablesName(re.getVariablesName()).build();
            recordDtoList.add(record);
        }
        return recordDtoList;
    }


    public Map<String, List<Object>> convertDetails() {
        List<MyRecord> reportData = recordRep.getPatientTestReportDetail("1","1");
        List<RecordDto> recordDto = getMyRecordsDto(reportData);
        Map<String, List<Object>> recordDetails = new HashMap<>();
        List<Object> patientDetails = recordDto.stream().distinct().map(p ->
                PatientDetailsDto.builder().patientName(p.getPatientName())
                        .age(p.getAge())
                        .patientCode(p.getPatientCode())
                        .referredBy(p.getReferredBy())
                        .gender(p.getGender())
                        .testName(p.getTestName())
                        .issueDate(p.getIssueDate())
                        .dateAndTime(p.getDateAndTime())
                        .clinicalNotes(p.getClinicalNotes()).build()).limit(1).collect(Collectors.toList());

        List<Object> resultDto = recordDto.stream().distinct().map(p ->
                ResultDto.builder().results(p.getResults())
                        .units(p.getUnits())
                        .referenceValue(p.getReferenceValue())
                        .variablesName(p.getVariablesName()).build()).collect(Collectors.toList());
        recordDetails.put("patientDetails", patientDetails);
        recordDetails.put("result", resultDto);

        // recordDetails.forEach((key, value) -> System.out.println(key + " " + value));
//        System.out.println(reportData.size()+" sizeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        System.out.println(recordDto.size()+"sizeeeeeeeeeeeeeeeeeeeeeeeeeeee");
//        for(Map.Entry<String,List<Object>> name: recordDetails.entrySet()){
//            System.out.println(name.getKey()+" key");
//            for (Object i:name.getValue()){
//                System.out.println(i+" value");
//            }
//        }

        return recordDetails;
    }
}

