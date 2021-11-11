package com.dio.citiesapi.cities.controller;


import com.dio.citiesapi.cities.entities.City;
import com.dio.citiesapi.cities.repositories.CityRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
@Api(value = "Search City")
public class CityResource {

    private final CityRepository repository;

    public CityResource(final CityRepository repository) {
        this.repository = repository;
    }

  /* 1st
  @GetMapping
  public List<City> cities() {
      return repository.findAll();
  }*/

    // 2nd - Pageable
    @ApiOperation(value = "Retorna uma lista paginada de cidades do Brasil"
            , notes = "get cities", httpMethod = "GET"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }
}