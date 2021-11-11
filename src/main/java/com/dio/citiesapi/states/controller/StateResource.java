package com.dio.citiesapi.states.controller;


import com.dio.citiesapi.states.entities.State;
import com.dio.citiesapi.states.repositories.StateRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/staties")
public class StateResource {

    private final StateRepository repository;

    public StateResource(final StateRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Retorna uma lista de Estados do Brasil"
                , notes = "get staties", httpMethod = "GET"
                , produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public List<State> staties() {
        return repository.findAll();
    }
}