/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.service;

import com.finalProject.Final.domain.Paciente;
import java.util.List;


public interface PacienteService {
    
    List<Paciente> findAll();
    
    Paciente findOne (Long obraId);
    
    Paciente finOne (Long pacienteId);
    
    void save(Paciente paciente);

    void delete(Long pacienId);
    
}
