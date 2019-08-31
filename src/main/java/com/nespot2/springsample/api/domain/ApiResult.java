package com.nespot2.springsample.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;


@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResult<T> {

    @JsonProperty
    private Code code;

    @JsonProperty
    private LocalDateTime time;

    @JsonProperty
    private T body;

    @JsonProperty
    private String message;

    public ApiResult(Code code, LocalDateTime time, T body, String message) {
        this.code = code;
        this.time = time;
        this.body = body;
        this.message = message;
    }

    public static <T> ApiResult<T> ok() {
        return new ApiResult<>(Code.SUCCESS, LocalDateTime.now(), null, null);
    }

    public static <T> ApiResult<T> ok(T body) {
        return new ApiResult<>(Code.SUCCESS, LocalDateTime.now(), body, null);
    }

    public static <T> ApiResult<T> fail(Code code) {
        return new ApiResult(code, LocalDateTime.now(), null, code.getMessage());
    }

    public static <T> ApiResult<T> fail(Code code, T body) {
        return new ApiResult(code, LocalDateTime.now(), body, code.getMessage());
    }

    public ResponseEntity mapperResponseEntity() {
        return ResponseEntity.status(this.code.getHttpStatus()).body(this);
    }
}
