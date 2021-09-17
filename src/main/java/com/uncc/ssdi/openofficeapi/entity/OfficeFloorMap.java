package com.uncc.ssdi.openofficeapi.entity;

import javax.persistence.*;

@Entity
@Table(name="office_floor_map")
public class OfficeFloorMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String building;

    @Column(nullable = false)
    private String floor;

    @Column(nullable = false)
    private String desk;

    @Column(nullable = false)
    private String available;

    @Column(nullable = false)
    private String reservedBy;
}
