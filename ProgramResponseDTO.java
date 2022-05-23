package com.customer.zokudo.dto.response;

import lombok.Data;
import org.codehaus.jettison.json.JSONObject;

@Data
public class ProgramResponseDTO {

    private long programId;

    private long clientId;

    private String programHashId;

    private String programName;

    private String programType;

    private JSONObject programDetails;
}
