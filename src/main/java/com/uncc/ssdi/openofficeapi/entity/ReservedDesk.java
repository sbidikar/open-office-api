package com.uncc.ssdi.openofficeapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="reserved_desk")
public class ReservedDesk implements Serializable {

    @Id
    @JsonProperty
    @Column
    private long userId;

    @JsonProperty
    @Column
    private String userName;

    @JsonProperty
    @Column
    private Long floorMapId;

    @JsonProperty
    @Column
    private Date reservedDate;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getFloorMapId() {
        return floorMapId;
    }

    public void setFloorMapId(Long floorMapId) {
        this.floorMapId = floorMapId;
    }

    public Date getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Date reservedDate) {
        this.reservedDate = reservedDate;
    }
}
