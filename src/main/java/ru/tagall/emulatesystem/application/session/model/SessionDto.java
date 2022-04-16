package ru.tagall.emulatesystem.application.session.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionDto {
    private Long id;
    private String sessionName;
    private String customerName;
    private Long currentPrice;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long bet;
    private String location;
    private String lastCustomerBet;
    private String status;
}