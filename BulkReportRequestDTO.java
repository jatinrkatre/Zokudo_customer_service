package com.customer.zokudo.dto.request;

import lombok.Data;

@Data
public class BulkReportRequestDTO {

    String name;
    String mobile;
    String email;
    String fileName;
    String dateRange;
}
