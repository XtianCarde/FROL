package com.riwi.frol.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "cliente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String name;
    private String password;
    private String email;
    private int age;
    private int phone;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude // @121312312
    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "cliente",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<Citas> citas;
}
