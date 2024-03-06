package com.ksatria.spring_reactive_htmx.registration;

import com.ksatria.spring_reactive_htmx.entity.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class PatientService {
    @Autowired
    private  PatientRepository patientRepository;

    public Flux<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    public Mono<PatientEntity> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Mono<PatientEntity> createPatient(PatientEntity patient) {
        return patientRepository.save(patient);
    }

    public Mono<Void> deletePatient(Long id) {
        return patientRepository.deleteById(id);
    }
}
