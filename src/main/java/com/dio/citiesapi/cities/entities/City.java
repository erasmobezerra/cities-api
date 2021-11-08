package com.dio.citiesapi.cities.entities;


import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade") // Caso não seja especificado, o nome da tabela será o nome da classe.
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class) // O atributo do tipo "point" deve utilizar a classe PointType
})
public class City {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    // Caso não seja especificado, o nome da coluna será o nome do atributo.
    private Integer uf;

    // Caso não seja especificado, o nome da coluna será o nome do atributo.
    private Integer ibge;

    // 1st
    @Column(name = "lat_lon") // Como foi especificado, o nome da coluna será "lat_lon" e não mais o nome do atributo "geolocation".
    private String geolocation;

//     2nd
    @Type(type = "point") // Este atributo utiliza a classe PointType a fim de compreender a informação no banco de dados
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;

    public City() {
    }

    public City(final Long id, final String name, final Integer uf, final Integer ibge,
                final String geolocation, final Point location) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.ibge = ibge;
        this.geolocation = geolocation;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public Point getLocation() {
        return location;
    }
}
