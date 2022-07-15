package com.shoplazza.exceptions;

import com.shoplazza.mappers.ResponseEntityToStringMapper;

import javax.ws.rs.core.Response;

public class ShoplaazaErrorResponseException extends RuntimeException {

    static final String MESSAGE = "Received unexpected Response Status Code of %d\nResponse Body of:\n%s\nResponse Headers of:\n%s";
    private static final long serialVersionUID = 5646635633348617058L;
    private final int statusCode;
    private final String responseBody;


    public ShoplaazaErrorResponseException(final Response response) {
        super(buildMessage(response));
        this.responseBody = ResponseEntityToStringMapper.map(response);
        this.statusCode = response.getStatus();
    }

    private static String buildMessage(final Response response) {
        final String readEntity = ResponseEntityToStringMapper.map(response);
        return String.format(MESSAGE, response.getStatus(), readEntity, response.getStringHeaders());
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

}
