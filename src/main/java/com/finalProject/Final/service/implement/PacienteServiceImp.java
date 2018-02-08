/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.service.implement;

import com.finalProject.Final.domain.Paciente;
import com.finalProject.Final.repository.PacienteRepository;
import com.finalProject.Final.service.PacienteService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Seguritech2
 */
@Service
@Transactional
public class PacienteServiceImp implements PacienteService{
    
    private final PacienteRepository pacienteRepository;

    public PacienteServiceImp(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    
    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente findOne(Long id) {
        return pacienteRepository.findOne(id);
    }

    
    
}
