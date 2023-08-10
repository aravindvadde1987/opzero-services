package com.opzero.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
public class Project {
    @Id
    @Column(name = "PROJECT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ACCOUNT_ID")
    private Long accountId;
    @Column(name = "PROJECT_NAME")
    private String projectName;
    private String scopeOfWork;
    private Long teamSize;
    private Long onshoreSize;
    private Long offshoreSize;
    private String engagementType;
    private String operatingModel;
    private boolean isActive;
    private String createdBy;
    private String updatedBy;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
