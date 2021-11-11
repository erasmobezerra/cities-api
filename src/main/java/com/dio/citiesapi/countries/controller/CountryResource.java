package com.dio.citiesapi.countries.controller;

import com.dio.citiesapi.countries.entities.Country;
import com.dio.citiesapi.countries.repositories.CountryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryResource {

    private final CountryRepository repository;

    // Necessário passar o construtor pois na Classe de origem não foi colocado Construtor.
    public CountryResource(CountryRepository repository) {
        this.repository = repository;
    }

//    @GetMapping
//    public List<Country> countries() {
//        return repository.findAll();
//    }

    /* Interface Page => Organiza a response de forma paginada: contend e detalhes da paginação
                       Sem necessidade de usar query, permite ordenar de várias formas as responses */
   @ApiOperation(value = "Retorna uma lista paginada de países"
                , notes = "get countries", httpMethod = "GET"
                , produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

//    @GetMapping("/{id}")
//    public Country getOne(@PathVariable Long id) {
//        Optional<Country> optional = repository.findById(id);
//        return optional.get();
//    }

    @ApiOperation(value = "Retorna um país pelo seu ID"
            , notes = "get country", httpMethod = "GET"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id);
        // Agregando HTTP status, tratamento de erros
        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }


    }

}