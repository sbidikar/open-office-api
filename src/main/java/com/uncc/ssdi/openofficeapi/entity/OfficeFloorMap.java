package com.uncc.ssdi.openofficeapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="office_floor_map")
public class OfficeFloorMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;

    @JsonProperty
    @Column(nullable = false)
    private String location;

    @JsonProperty
    @Column(nullable = false)
    private String building;

    @JsonProperty
    @Column(nullable = false)
    private String floor;

    @JsonProperty
    @Column(nullable = false)
    private String desk;
}
