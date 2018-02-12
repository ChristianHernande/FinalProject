/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.controller;

import com.finalProject.Final.domain.Paciente;
import com.finalProject.Final.service.PacienteService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDPacienteControllerTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    CRUDPacienteController cRUDPacienteController;
    
    @Mock
    private PacienteService pacienteService;
    
    @Before
    public void setUp() {
        
        MockitoAnnotations.initMocks(this);
        
        Paciente paciente = new Paciente();
        
        paciente.setId(1L);
        paciente.setDni("12345678");
        paciente.setNombre("Jennifer Lopez");
        paciente.setEmail("jennifer@gmail.com");
        paciente.setTelefono(null);
        paciente.setObraId(1L);
        paciente.setEstado("HABILITADO");
        paciente.setFechaCreacion("2018-01-26 00:00:00");
        Mockito.when(pacienteService.finOne(1L)).thenReturn(paciente);
                        
        mockMvc = MockMvcBuilders.standaloneSetup(cRUDPacienteController).build();
        
    }

    @Test
    public void testGetPaciente() throws Exception{
        System.out.println("getPaciente");
        final Long pacienteId = 1L;
        mockMvc.perform(get("/administrador/pacientes_s/" + pacienteId)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").isNumber())
        .andExpect(jsonPath("$.id").value(pacienteId))
        .andExpect(jsonPath("$.dni").isString())
        .andExpect(jsonPath("$.nombre").isString())
        .andExpect(jsonPath("$.email").isString()) 
        .andExpect(jsonPath("$.telefono").doesNotExist())
        .andExpect(jsonPath("$.obraId").isNumber())
        .andExpect(jsonPath("$.estado").isString())
        .andExpect(jsonPath("$.fechaCreacion").isString());                
    }

    @Test
    public void testGetPacientes_isError404() throws Exception {
        System.out.println("getPaciente");
        final Long id = 7L;

        mockMvc.perform(get("/administrador/pacientes_s/" + id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }
   
    
}
