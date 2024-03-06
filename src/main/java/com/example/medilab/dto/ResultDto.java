package com.example.medilab.dto;

import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDto {
    private String variablesName;
    private String units;
    private String referenceValue;
    private String results;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ResultDto that = (ResultDto) o;
//        return Objects.equals(variablesName, that.variablesName);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(variablesName, units, referenceValue, results);
    }
}
