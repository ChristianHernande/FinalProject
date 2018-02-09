/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.repository;

import com.finalProject.Final.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicoRespository extends JpaRepository<Medico, Long>{
    
}
