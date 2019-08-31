package com.nespot2.springsample.common.advice;


import com.nespot2.springsample.api.domain.ApiResult;
import com.nespot2.springsample.api.domain.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResult<List<ObjectError>>> notValidException(MethodArgumentNotValidException e) {
        final BindingResult bindingResult = e.getBindingResult();
        final List<ObjectError> allErrors = bindingResult.getAllErrors();
        return ApiResult.fail(Code.ARGUMENT_NOT_VALID,allErrors).mapperResponseEntity();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResult<String>> runtimeException(RuntimeException e) {
        return ApiResult.fail(Code.ERROR, e.getMessage()).mapperResponseEntity();
    }


}
