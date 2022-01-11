package com.csseifms.seshat.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
public class Interest {
    @Column
    String name;
    @Column
    @Id
    String tag;

    public Interest(String name) {
        this.name = name;
    }
}
