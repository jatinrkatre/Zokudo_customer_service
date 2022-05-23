package com.customer.zokudo.dto.request;

import lombok.Data;

@Data
public class KarzaFlags {

    private KarzaParams pan;
    private KarzaParams dob;
    private KarzaParams name;
    private KarzaParams fathersName;
}
