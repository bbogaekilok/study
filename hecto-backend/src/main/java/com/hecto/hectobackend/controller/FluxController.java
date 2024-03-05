package com.hecto.hectobackend.controller;

import com.hecto.hectobackend.domain.DataTime;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/flux")
public class FluxController {


    @GetMapping()
    public Mono<LocalDateTime> mono(){

        // 현재 날짜와 시간 구하기
        LocalDateTime currentDateTime = LocalDateTime.now();
        return Mono.just(currentDateTime);
    }


    @GetMapping("/")
    public Flux<DataTime> flux(){
        // 현재 날짜 구하기
        LocalDate currentDate = LocalDate.now();

        // 현재 시간 구하기
        LocalTime currentTime = LocalTime.now();

        // 현재 날짜와 시간 구하기
        LocalDateTime currentDateTime = LocalDateTime.now();

        return Flux.just(new DataTime(currentDate, currentTime, currentDateTime)).log();
    }

    @GetMapping(value = "/fluxstream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Integer> fluxStream(){
        return Flux.just(1,2,3,4,5,6).delayElements(Duration.ofSeconds(1)).log();
    }
}
