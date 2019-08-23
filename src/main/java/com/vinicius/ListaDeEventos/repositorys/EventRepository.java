package com.vinicius.ListaDeEventos.repositorys;

import com.vinicius.ListaDeEventos.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Evento, String> {}
