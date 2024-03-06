package com.ksatria.spring_reactive_htmx.registration;

import com.ksatria.spring_reactive_htmx.entity.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public String getAllPatients(Model model) {
        Flux<PatientEntity> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient";
    }

    @PostMapping("/create")
    public Mono<String> createPatient(@ModelAttribute PatientEntity patient) {
        return patientService.createPatient(patient)
                .then(Mono.just("redirect:/patients/"));
    }

    @GetMapping("/{id}")
    public Mono<String> getPatientById(@PathVariable Long id, Model model) {
        Mono<PatientEntity> patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return Mono.just("patient");
    }

    @PostMapping("/{id}/delete")
    public Mono<String> deletePatient(@PathVariable Long id) {
        return patientService.deletePatient(id)
                .then(Mono.just("redirect:/patients/"));
    }
}
