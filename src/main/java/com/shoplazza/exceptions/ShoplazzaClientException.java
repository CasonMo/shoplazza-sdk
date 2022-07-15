package com.shoplazza.exceptions;

public class ShoplazzaClientException extends RuntimeException {

    private static final long serialVersionUID = -5992356578452439224L;

    public ShoplazzaClientException(final Throwable throwable) {
        super(throwable);
    }

    public ShoplazzaClientException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

}
