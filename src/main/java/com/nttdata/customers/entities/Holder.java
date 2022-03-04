package com.nttdata.customers.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "holders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Holder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    private String firstnames;

    @NotBlank
    @NotNull
    private String lastnames;

    @NotBlank
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    @Column(unique = true)
    private String dni;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Customer customer;

}
