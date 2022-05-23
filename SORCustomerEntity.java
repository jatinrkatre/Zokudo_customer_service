package com.customer.zokudo.entities;


import com.customer.zokudo.enums.ProgramPlans;
import com.customer.zokudo.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer", indexes = {
        @Index(name = "created_at", columnList = "created_at")
})
@Data
public class SORCustomerEntity extends AbstractEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "preferred_name")
    private String preferredName;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "customer_hash_id")
    private String customerHashId;

    @Column(name = "processor_id")
    private int processorId;

    @Column(name = "program_id")
    private int programId;

    @Enumerated(EnumType.STRING)
    @Column(name = "program_plan")
    private ProgramPlans programPlan;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_type")
    private Status kycType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, unique = true)
    private CustomerDetails customerDetails;

    @Column(name = "agent_hash_id")
    private String agentHashId;

    @Column(name = "distributor_hash_id")
    private String distributorHashId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_hash_id")
    private String userHashId;

    @Column(name = "fee_deduction")
    private boolean feeDeduction = false;



}
