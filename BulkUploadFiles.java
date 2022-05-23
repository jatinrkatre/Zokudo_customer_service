package com.customer.zokudo.entities;

import com.customer.zokudo.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bulk_upload_files")
@Data
public class BulkUploadFiles extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String fileName;

    @Column(nullable = false)
    private String programHashId;

    @Column(nullable = false, unique = true)
    private String s3path;

    private long totalCount;

    private long successCount;

    private long failureCount;

    private String description;

    private String catagory;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String orginalFileName;
    private String agentHashId;

}
