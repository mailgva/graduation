package com.gorbatenko.util.exception;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.http.HttpStatus;

import javax.lang.model.type.ErrorType;

public class NotFoundException extends Throwable { //extends ApplicationException {
    public static final String NOT_FOUND_EXCEPTION = "exception.common.notFound";

    //  http://stackoverflow.com/a/22358422/548473
    public NotFoundException(String arg) throws Exception {
        //super(ErrorType.DATA_NOT_FOUND, NOT_FOUND_EXCEPTION, HttpStatus.UNPROCESSABLE_ENTITY, arg);
        throw new Exception(arg);
    }
}