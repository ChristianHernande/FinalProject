/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.repository;

import com.finalProject.Final.domain.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
   //Paciente findByObraId(Long obraId);
    
    List<Paciente> findByObraId (Long obraId);
}
