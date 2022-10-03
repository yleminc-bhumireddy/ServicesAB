package com.mycomp.model;

//import lombok.*;

import java.io.Serializable;

//@Data
//@Builder
//@AllArgsConstructor
//@Setter
//@NoArgsConstructor
public class PingResponse implements Serializable {

    private String ipAddress;

    private String hostName;

    private String response;

    private PingResponse nextResponse;


    public PingResponse() {
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public PingResponse getNextResponse() {
        return nextResponse;
    }

    public void setNextResponse(PingResponse nextResponse) {
        this.nextResponse = nextResponse;
    }
}
