package br.com.tech4me.clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.clinica.model.DoctorData;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {

List<DoctorData> doctors = new ArrayList<>();

@GetMapping
private List<DoctorData> getRequest() {
    return doctors;
}

@GetMapping("/{name}")
private String getRequestWithParameter(@PathVariable String name) {
    return String.format("Página com informações do Dr. %s", name);
}

@PostMapping
private String postRequest(@RequestBody DoctorData doctor) {
    doctors.add(doctor);
    return String.format("Adicionei na lista os dados do médico: %s", doctor.name());
}



}
