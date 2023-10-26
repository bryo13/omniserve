package com.group3.omniserve.omniserve.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tasks")

// called Tasks away from the convention to call models in singular to avoid
// importing collitions with internal classes
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private long taskID;
    private String title;
    private String description;
    private String additionalFiles;

    // FetchType set to lazy for performance purposes
    /*
     * the pros of @ManyToOne annotation.
     * – With @OneToMany, we need to declare a collection inside parent class, we
     * cannot limit the size of that collection, for example, in case of pagination.
     * – With @ManyToOne, you can modify Repository:
     * 
     * to work with Pagination, the instruction can be found at:
     * Spring Boot Pagination & Filter example | Spring JPA, Pageable
     * or to sort/order by multiple fields:
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
