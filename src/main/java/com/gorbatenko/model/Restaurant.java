package com.gorbatenko.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("JpaQlInspection")
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {
    public Restaurant() {
    }

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
