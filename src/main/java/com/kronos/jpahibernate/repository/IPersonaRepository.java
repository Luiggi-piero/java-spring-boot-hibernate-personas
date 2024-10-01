package com.kronos.jpahibernate.repository;

import com.kronos.jpahibernate.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// La interface extiende de JpaRepository, que maneja repositorios jpa
// en los parámetros <> deben ir: <clase a persistir, tipo de datos de su ID>
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
}
