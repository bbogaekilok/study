package com.hecto.hectobackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
public class DataTime {

    private LocalDate currentDate;
    private LocalTime currentTime;
    private LocalDateTime currentDateTime;

}
