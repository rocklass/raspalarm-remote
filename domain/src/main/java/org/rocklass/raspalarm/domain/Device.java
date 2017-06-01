package org.rocklass.raspalarm.domain;

/**
 * Class that represents a Device in the domain layer.
 */
public class Device {

    private final String token;

    public Device(final String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
