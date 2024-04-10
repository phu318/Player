package com.codegym.quanlycauthu1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "player")
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String experience;
    @Enumerated(EnumType.STRING)
    private EPosition eposition;
    public PlayerResDto toResDto(){
        return new PlayerResDto(id,name,dateOfBirth,eposition,experience);
    }

}
