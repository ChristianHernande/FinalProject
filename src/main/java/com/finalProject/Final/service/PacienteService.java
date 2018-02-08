/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.service;

import com.finalProject.Final.domain.Paciente;
import java.util.List;

/**
 *
 * @author Seguritech2
 */
public interface PacienteService {
    
    List<Paciente> findAll();
    
    Paciente findOne (Long obraid);
    
}
