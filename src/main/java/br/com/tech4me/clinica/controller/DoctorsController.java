package br.com.tech4me.clinica.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public DoctorData getDoctorByName(@PathVariable String name) {
    DoctorData doctor = doctors.stream().filter(d -> d.name()
    .equalsIgnoreCase(name)).findFirst().orElse(null);
    return doctor;
}

@PostMapping
public ResponseEntity<String> postRequest(@RequestBody DoctorData doctor) {
    String message = String.format("Adicionei na lista os dados do médico: %s", doctor.name());
    doctors.add(doctor);
    return new ResponseEntity<String>(message, HttpStatus.CREATED);
}

@PutMapping("/{name}")
public DoctorData updateDoctorByName(@PathVariable String name, @RequestBody DoctorData newDoctor) {
    int index = -1;
    for (int i = 0; i < doctors.size(); i++) {
        if (doctors.get(i).name().equalsIgnoreCase(name)) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        DoctorData updatedDoctor = new DoctorData(newDoctor.name(), newDoctor.skill(), newDoctor.visitValue());
        doctors.set(index, updatedDoctor);
        return updatedDoctor;
    }

    return null;
}


@DeleteMapping("/{name}")
public void deleteDoctorByName(@PathVariable String name) {
    doctors.removeIf(d -> d.name().equals(name));
}




}
