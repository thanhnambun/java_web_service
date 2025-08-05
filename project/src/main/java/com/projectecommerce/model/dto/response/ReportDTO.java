package com.projectecommerce.model.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDTO {
    private Integer timeUnit;
    private Number totalAmount;
}