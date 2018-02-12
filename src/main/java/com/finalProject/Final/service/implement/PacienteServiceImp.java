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
    public Paciente finOne(Long pacienteId) {
        return pacienteRepository.findOne(pacienteId);
    }

    @Override
    public List<Paciente> findByObraId(Long obraId) {
        return pacienteRepository.findByObraId(obraId);
    }
        
    @Override
    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void delete(Long pacienId) {
        pacienteRepository.delete(pacienId);
    }

    
    
    
}
