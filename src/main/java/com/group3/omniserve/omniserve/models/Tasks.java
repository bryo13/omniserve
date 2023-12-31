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
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@Table(name = "tasks")

// called Tasks away from the convention to call models in singular to avoid
// importing collitions with internal classes
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "task_id")
    private long taskID;
    private String title;
    private String description;
    private float amount;

    // we use int which we will cast into an object of type Duration and add to the createdAt 
    // value 
    private int durationInDays;

    // additionalFiles is of type string as it will hold a url to the blobs holding files
    // in line with file handling good practices.
    @Column(name = "additional_files")
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
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;
}
