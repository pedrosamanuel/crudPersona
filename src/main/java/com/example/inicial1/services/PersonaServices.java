package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServices {
    @Autowired
    private PersonaRepository personaRepository;
    public List<Persona> findAll () throws Exception{
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Persona findById(Long id) throws Exception{
        try {
            return personaRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Persona save(Persona persona) throws Exception{
        try {
            return personaRepository.save(persona);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Persona update(Long id, Persona updatedPersona) throws Exception{
        try {
            Optional<Persona> optionalPersona = personaRepository.findById(id);
             Persona persona = optionalPersona.get();
             persona.setApellido(updatedPersona.getApellido());
             persona.setDomicilio(updatedPersona.getDomicilio());
             persona.setNombre(updatedPersona.getNombre());
             return personaRepository.save(persona);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    public boolean delete(Long id) throws Exception{
        try {
            Optional<Persona> optionalPersona = personaRepository.findById(id);
            Persona persona = optionalPersona.get();
            personaRepository.deleteById(persona.getId());
            return true;
        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}
