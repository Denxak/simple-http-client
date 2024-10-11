package ait.converterfixed.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private String date;
    private String historical;
    private Info info;
    private Query query;
    private double result;
    private boolean success;
}
