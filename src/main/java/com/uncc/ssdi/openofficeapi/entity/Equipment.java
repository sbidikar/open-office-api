package com.uncc.ssdi.openofficeapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="equipment")
public class Equipment implements Serializable {
    @Id
    @JsonProperty
    @Column
    private long itemId;

    @JsonProperty
    @Column
    private String name;

    @JsonProperty
    @Column
    private String purpose;

    @JsonProperty
    @Column
    private String deskId;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }
}
