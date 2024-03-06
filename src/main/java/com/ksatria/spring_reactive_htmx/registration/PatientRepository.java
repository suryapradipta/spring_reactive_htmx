package com.ksatria.spring_reactive_htmx.registration;

import com.ksatria.spring_reactive_htmx.entity.PatientEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


public interface PatientRepository extends ReactiveCrudRepository<PatientEntity, Long> {

}
