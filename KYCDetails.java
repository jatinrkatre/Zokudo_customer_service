package com.customer.zokudo.entities;

import com.customer.zokudo.enums.KycStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "kyc_details")
public class KYCDetails extends AbstractEntity {

    @Column(name = "kyc_details_id", nullable = false, unique = true)
    private String kycDetailsId;

    @Column(name = "customer_id", nullable = false)
    private long customerId;

    @Column(name = "program_id", nullable = false)
    private long programId;

    @Column(name = "program_name", nullable = false)
    private String programName;

    @Column(name = "customer_mobile", nullable = false)
    private String customerMobile;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "name_on_document")
    private String nameOnDoc;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "document_number")
    private String idNumber;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "doc_image_url_front")
    private String docImageUrlFront;

    @Column(name = "doc_image_url_back")
    private String docImageUrlBack;

    @Column(name = "kyc_type")
    private String kycType;

    @Column(name = "kyc_status")
    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kyc_details_by_karza", referencedColumnName = "id")
    KYCDetailsByKarza kycDetailsByKarza;


}
