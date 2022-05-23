package com.customer.zokudo.services;

import com.customer.zokudo.dto.response.ProgramResponseDTO;
import org.codehaus.jettison.json.JSONObject;

public interface ProductService {

    ProgramResponseDTO getProgramById(long programId, String programUrl);

    JSONObject getAgentDetails(String agentHashId,String programUrl);
}
