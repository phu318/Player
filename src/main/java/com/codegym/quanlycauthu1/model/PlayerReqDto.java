package com.codegym.quanlycauthu1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerReqDto {
    private String name;
    private LocalDate dateOfBirth;
    private EPosition eposition;
    private String experience;
}
