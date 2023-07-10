package com.wagner.cardapio.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class LogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @CreatedDate
    @JoinColumn(name = "createddate", nullable = false, updatable = true)
    private Date createdDate;


    @LastModifiedDate
    @JoinColumn(name = "lastmodifieddate", nullable = false, updatable = true)
    private Date lastModifiedDate;

    @JoinColumn(name = "status", nullable = false, updatable = true, columnDefinition = "true")
    private Boolean status;

    @PrePersist
    public void prePersist(){
        if (status == null){
            status = true;
        }
        if (lastModifiedDate == null){
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            lastModifiedDate = date;
        }
        if (createdDate == null){
            LocalDate localDate = LocalDate.now();
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            createdDate = date;
        }
    }
}
