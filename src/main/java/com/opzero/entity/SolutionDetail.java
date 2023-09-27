package com.opzero.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SolutionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SOLUTION_ID")
    private Long id;
    private String solutionImplemented;
    private String technologiesUsed;
    private String solutionLink;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "DATA_DETAIL_ID")
    private DataDetail dataDetail;
}
