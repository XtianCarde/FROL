package com.riwi.frol.domain.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "company")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String name;
    private String service;
    private String description;
    private String nit;
    private String urlImg;
    private String email;
    private String password;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // @121312312
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<Cita> citas; // Es una lista de citas no de String
}
