package com.ksatria.spring_reactive_htmx.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table("patients")
public class PatientEntity {

    @Id
    private Long id;

    private String name;

    private String condition;
}
