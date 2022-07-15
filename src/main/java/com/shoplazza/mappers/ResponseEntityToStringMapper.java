package com.shoplazza.mappers;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ResponseEntityToStringMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseEntityToStringMapper.class);

    private ResponseEntityToStringMapper() {
    }

    public static String map(final Response response) {

        try {
            response.bufferEntity();
            final InputStream entityBytes = (InputStream) response.getEntity();
            final String responseBody = IOUtils.toString(entityBytes, StandardCharsets.UTF_8.toString());
            entityBytes.reset();
            return responseBody;
        } catch (final Exception e) {
            LOGGER.error("There was an error parsing response body on response with status {}, returning null",
                    response.getStatus());
            return null;
        }
    }

}
