package com.kronos.jpahibernate.controller;

import com.kronos.jpahibernate.model.Mascota;
import com.kronos.jpahibernate.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService serviMascota;

    @PostMapping("/mascotas/crear")
    public String saveMascota(@RequestBody Mascota masco){
        serviMascota.saveMascota(masco);
        return "Mascota creada con éxito";
    }
}
