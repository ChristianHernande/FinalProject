/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.controller;

import com.finalProject.Final.domain.Paciente;
import com.finalProject.Final.service.PacienteService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Seguritech2
 */
@RestController
public class PacienteController {
    
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    
    @GetMapping(value = "/administrador/pacientes")
    public List<Paciente> listAll(){
        List<Paciente> pacientes = pacienteService.findAll();
        System.out.println(pacientes.size());
        return pacientes;
    }
    
//    @GetMapping(value = "/administrador/pacientes/{obraid}")
//    public ResponseEntity <Paciente> getPaciente(@PathVariable(obraid) Long obraid){
//        Paciente paciente = pacienteService.findOne(id);
//        if(paciente == null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(paciente);
//    }
    
}
