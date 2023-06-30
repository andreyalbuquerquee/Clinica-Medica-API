package br.com.tech4me.clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.clinica.model.ProcedureData;

@RestController
@RequestMapping("/{procedures}")
public class ProceduresController {
    List<ProcedureData> procedures = new ArrayList<>();

@GetMapping
private List<ProcedureData> getRequest() {
    return procedures;
}

@PostMapping
private String postRequest(@RequestBody ProcedureData procedure) {
    procedures.add(procedure);
    return String.format("Adicionado o procedimento %s", procedure.description());
}


}
