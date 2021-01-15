package com.glaucus.incrementVal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Sample {

    @Id
    private int id;
}
