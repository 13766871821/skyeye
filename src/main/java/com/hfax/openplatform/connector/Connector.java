package com.hfax.openplatform.connector;

public interface Connector {
		
    /**
     * Sends the request object to the backend systems and receives the response object. 
     * Used for synchronous processing
     * 
     * @param pRequest
     * @return
     * @throws Exception
     */
    String sendAndReceive(String pRequest) throws ConnectorException;


}
