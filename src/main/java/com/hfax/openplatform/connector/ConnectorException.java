package com.hfax.openplatform.connector;

public class ConnectorException extends Exception {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * default constructor.
     */
    public ConnectorException() {
        super();

    }

    /**
     * @param message
     *            holds input data
     */
    public ConnectorException(final String message) {
        super(message);

    }

    /**
     * 
     * @param throwable
     *            the throwable
     */
    public ConnectorException(final Throwable throwable) {
        super(throwable);
    }

    /**
     * @param message
     *            holds input message
     * @param throable
     *            holds
     */
    public ConnectorException(final String message, final Throwable throable) {
        super(message, throable);

    }

}
