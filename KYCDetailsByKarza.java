package com.customer.zokudo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "kyc_details_by_karza")
public class KYCDetailsByKarza extends AbstractEntity {

    @OneToOne(mappedBy = "kycDetailsByKarza")
    KYCDetails kycDetails;

    @Column(name = "father_name_on_doc")
    private String fatherNameOnDoc;

    @Column(name = "father_conf_score")
    private String fatherConfScore;

    @Column(name = "name_on_doc")
    private String nameOnDoc;

    @Column(name = "name_conf_score")
    private String nameConfScore;

    @Column(name = "dob_on_doc")
    private String dobOnDoc;

    @Column(name = "dob_conf_score")
    private String dobConfScore;

    @Column(name = "address_on_doc")
    private String addressOnDoc;

    @Column(name = "address_conf_score")
    private String addressConfScore;


    @Column(name = "id_number_on_doc")
    private String idNumberOnDoc;

    @Column(name = "id_number_conf_score")
    private String idNumberConfScore;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "gov_data_name_match")
    private String govDataNameMatch;

    @Column(name = "gov_data_dob_match")
    private String govDataDobMatch;

    @Column(name = "gov_data_name_score")
    private String govDataNameScore;

    @Column(name = "gov_data_address_match")
    private String govDataAddressMatch;

    @Column(name = "gov_data_address_score")
    private String govDataAddressScore;

    @Column(name = "epic_no")
    private String epicNo;
    @Column(name = "verified_name")
    private String verifiedName;
    @Column(name = "verified_dob")
    private String verifiedDob;
    @Column(name = "verified_address")
    private String verifiedAddress;
    @Column(name = "verified_doc_status")
    private String verifiedDocStatus;
    @Column(name = "issue_date")
    private String issueDate;
    @Column(name = "non_transport_dl_validity")
    private String nonTrDlValidity;
    @Column(name = "transport_dl_validity")
    private String trDlValidity;

}
