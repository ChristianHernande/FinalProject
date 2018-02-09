/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.service;

import com.finalProject.Final.domain.Medico;
import java.util.List;

public interface MedicoService {
    
    
    List<Medico> findAll();

    Medico findOne(Long id);

    void save(Medico medico);

    void delete(Long id);
    
}
