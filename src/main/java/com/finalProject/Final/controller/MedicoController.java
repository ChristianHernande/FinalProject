/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.controller;

import com.finalProject.Final.domain.Medico;
import com.finalProject.Final.service.MedicoService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicoController {
    
    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
    
    @GetMapping(value = "/administrador/medicos")
    public List <Medico> listAll(){
        List<Medico> medicos = medicoService.findAll();
        System.err.println(medicos.size());
        return medicos;
    }
    
    @GetMapping(value = "/administrador/medicos/{id}")
    public ResponseEntity <Medico> getMedico(@PathVariable("id") Long id){
        Medico medico = medicoService.findOne(id);
        if(medico == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }
    
    @PostMapping(value = "/administrador/medicos/nuevo")
    public ResponseEntity <Medico> create(@RequestBody Medico medico) throws  URISyntaxException{
        if(medico.getMedicoId() != null){
            return ResponseEntity.badRequest().header("X-error", "El id debe ser nulo").body(null);
        }
        medicoService.save(medico);
        return ResponseEntity.created(new URI("/administrador/medicos/nuevo/"+medico.getMedicoId())).body(medico);
        
    }
    
    @PutMapping(value = "/administrador/medicos/modificar")
    public ResponseEntity<Medico> update (@RequestBody Medico medico) throws Exception{
        if(medico.getMedicoId() == null){
            return ResponseEntity.badRequest().header("X-error", "El id no debe de ser nulo").body(null);
            
        }
        medicoService.save(medico);
        return ResponseEntity.ok().body(medico);
    }
    
    @DeleteMapping(value = "/administrador/medicos/borrar/{medicoId}")
    public ResponseEntity <Medico> deleteMedico(@PathVariable("medicoId") Long medicoId){
        medicoService.delete(medicoId);
        return ResponseEntity.ok().build();
    }
    
    
}
