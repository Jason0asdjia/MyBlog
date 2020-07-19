package com.jason;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Jason
 * @date 7/19/2020 9:05 PM
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException() {
    }
}
