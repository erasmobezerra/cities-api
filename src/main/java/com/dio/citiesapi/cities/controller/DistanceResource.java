package com.dio.citiesapi.cities.controller;


import com.dio.citiesapi.cities.service.DistanceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/distances")
public class DistanceResource {

    private final DistanceService service;
    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    public DistanceResource(DistanceService service) {
        this.service = service;
    }

    @ApiOperation(value = "Cálculo da distância por pontos em milhas."
            , notes = "get distanceByPointsInMiles", httpMethod = "GET"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return service.distanceByPointsInMiles(city1, city2);
    }


    @ApiOperation(value = "Cálculo da distância por cubo em metros"
            , notes = "get distanceByCubeInMeters", httpMethod = "GET"
            , produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return service.distanceByCubeInMeters(city1, city2);
    }

//    @GetMapping("/by-math")
//    public Double byMath(@RequestParam(name = "from") final Long city1,
//                         @RequestParam(name = "to") final Long city2,
//                         @RequestParam final EarthRadius unit) {
//        log.info("byMath");
//        return service.distanceUsingMath(city1, city2, unit);
//    }
}
