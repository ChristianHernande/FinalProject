/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.service.implement;

import com.finalProject.Final.domain.Medico;
import com.finalProject.Final.repository.MedicoRespository;
import com.finalProject.Final.service.MedicoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicoServiceImp implements MedicoService{
    
    private final MedicoRespository medicoRespository;

    public MedicoServiceImp(MedicoRespository medicoRespository) {
        this.medicoRespository = medicoRespository;
    }
    
    @Override
    public List<Medico> findAll() {
        return medicoRespository.findAll();
    }

    @Override
    public Medico findOne(Long id) {
        return medicoRespository.findOne(id);
    }

    @Override
    public void save(Medico medico) {
        medicoRespository.save(medico);
    }

    @Override
    public void delete(Long id) {
        medicoRespository.delete(id);
    }
    
}
