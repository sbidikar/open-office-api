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
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeskId() {
        return deskId;
    }

    public void setDeskId(String deskId) {
        this.deskId = deskId;
    }
}
