package com.kronos.jpahibernate.service;

import com.kronos.jpahibernate.model.Persona;
import com.kronos.jpahibernate.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements  IPersonaService {

    @Autowired
    private IPersonaRepository persoRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
//        No solo crea, tambien actualiza
        persoRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
//        Busco la persona
        Persona perso = this.findPersona(idOriginal);

//        Modifico sus atributos
        perso.setId(idNueva);
        perso.setApellido(nuevoApellido);
        perso.setNombre(nuevoNombre);
        perso.setEdad(nuevaEdad);

//        Guardo cambios
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }
}
