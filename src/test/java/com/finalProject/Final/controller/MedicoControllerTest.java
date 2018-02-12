/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finalProject.Final.controller;

import com.finalProject.Final.domain.Medico;
import com.finalProject.Final.service.MedicoService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicoControllerTest {
    
    private MockMvc mockMvc;
    
    @Autowired
    private MedicoController medicoController;
    
    @Mock
    private MedicoService medicoService;
        
    public MedicoControllerTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        Medico medico = new Medico();
        medico.setMedicoId(7L);
        medico.setNombre("Mariana Montes");
        medico.setEspecialidadId(1L);
        medico.setEstado("HABILITADO");
        Mockito.when(medicoService.findOne(7L)).thenReturn(medico);
                
        
        
        mockMvc = MockMvcBuilders.standaloneSetup(medicoController).build();
    }
    
    /**
     * Test of getMedico method, of class MedicoController.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetMedicoIsOk() throws Exception {
        System.out.println("getMedico");
        final Long medicoId = 7L;
        mockMvc.perform(get("/administrador/medicos/" + medicoId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.medicoId").isNumber())
                .andExpect(jsonPath("$.medicoId").value(medicoId))
                .andExpect(jsonPath("$.nombre").isString())
                .andExpect(jsonPath("$.especialidadId").isNumber())
                .andExpect(jsonPath("$.estado").isString());
        
        }
    
        @Test
    public void testGetMedicos_isError404() throws Exception {
        System.out.println("getRol");
        final Long medicoId = 7L;

        mockMvc.perform(get("/administrador/medicos/" + medicoId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string(""));
    }
       
}
