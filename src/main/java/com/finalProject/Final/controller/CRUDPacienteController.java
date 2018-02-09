/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.controller;

import com.finalProject.Final.domain.Paciente;
import com.finalProject.Final.service.PacienteService;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRUDPacienteController {
    
    private final PacienteService pacienteService;

    public CRUDPacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping(value = "/administrador/pacientes/{pacienteId}")
    public ResponseEntity <Paciente> getPaciente(@PathVariable("pacienteId")Long pacienteId){
        Paciente paciente = pacienteService.finOne(pacienteId);
        if(paciente==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }
    
    @PostMapping(value = "/administrador/pacientes/nuevo")
    public ResponseEntity <Paciente> create(@RequestBody Paciente paciente)throws URISyntaxException{
        if(paciente.getId() != null){
            return ResponseEntity.badRequest().header("X-error", "El id debe ser nulo").body(null);
        }
        pacienteService.save(paciente);
        return ResponseEntity.created(new URI("/administrador/pacientes/nuevo/"+ paciente.getId())).body(paciente);
    }
    
    @PutMapping(value = "/administrador/pacientes/modificar")
    public ResponseEntity<Paciente> update (@RequestBody Paciente paciente) throws Exception{
        if(paciente.getId() == null){
            return ResponseEntity.badRequest().header("X-error", "El id no debe de ser nulo").body(null);          
        }
        pacienteService.save(paciente);
        return ResponseEntity.ok().body(paciente);
    }
    
    @DeleteMapping(value = "/administrador/pacientes/borrar/{id}")
    public ResponseEntity <Paciente> deletePaciente(@PathVariable("id") Long id){
        pacienteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
