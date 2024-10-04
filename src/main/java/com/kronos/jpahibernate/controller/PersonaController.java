package com.kronos.jpahibernate.controller;

import com.kronos.jpahibernate.model.Persona;
import com.kronos.jpahibernate.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

//   Inyeccion del servicio
    @Autowired
    private IPersonaService interPersona;

//    Endpoint para traer todas las personas
    @GetMapping("/personas")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
    }

//    Endpoint para crear un persona
    @PostMapping("/personas")
    public String createPersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "Persona creada exitosamente";
    }

//    Endpoint para eliminar una persona por id
    @DeleteMapping("/personas/{id}")
    public String deletePersona(@PathVariable Long id){
        interPersona.deletePersona(id);
        return "Persona eliminada correctamente";
    }

//    Endpoint para modificar una persona
    @PutMapping("/personas/{id_modificar}")
    public Persona editPersona(@PathVariable Long id_modificar,
                               @RequestParam(required = false, name = "id") Long nuevaId,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "apellido") String nuevoApellido,
                               @RequestParam(required = false, name = "edad") int nuevaEdad
                                ){

//        Se envía el id original y los nuevos datos
        interPersona.editPersona(id_modificar, nuevaId, nuevoNombre, nuevoApellido, nuevaEdad);

//        Se busca la persona editada para mostrarla en la respuesta
        Persona perso = interPersona.findPersona(id_modificar);
        return perso;
    }

    @PutMapping("/personas/editar")
    public Persona editPersona(@RequestBody Persona per){
        interPersona.editPersona(per);

        return interPersona.findPersona(per.getId());
    }


}
