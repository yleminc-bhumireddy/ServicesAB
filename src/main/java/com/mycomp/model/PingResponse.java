package com.mycomp.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class PingResponse implements Serializable {

    private String ipAddress;

    private String hostName;

    private String response;

    private PingResponse nextResponse;


}
