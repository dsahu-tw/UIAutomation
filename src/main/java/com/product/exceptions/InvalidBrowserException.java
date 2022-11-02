package com.product.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidBrowserException extends Exception {
    public InvalidBrowserException(String msg) {
        super(msg);
    }

}
