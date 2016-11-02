package com.emil.core;

import javax.persistence.*;

/**
 * Created by emil on 11/2/16.
 */
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version;

    protected BaseEntity(){
        this.id = null;
    }
}
