package com.nespot2.springsample.api.domain;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@ToString
public enum Code {
    SUCCESS(0, HttpStatus.OK, "ok"),
    BAD_REQUEST(1, HttpStatus.BAD_REQUEST, "bad request"),
    ARGUMENT_NOT_VALID(2, HttpStatus.BAD_REQUEST, "argument not valid"),
    ERROR(3, HttpStatus.INTERNAL_SERVER_ERROR, "error");


    private int id;
    private HttpStatus httpStatus;
    private String message;

    @JsonValue
    public int getId() {
        return id;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return this == SUCCESS;
    }

    public boolean isBadRequest() {
        return this == BAD_REQUEST;
    }
}
