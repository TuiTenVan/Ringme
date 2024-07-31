package com.exampleProject.Restaurant.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -863164858986274318L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @CreatedDate
    private Date createdDate;

    @Column(name = "modified_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    @LastModifiedDate
    private Date modifiedDate;

}
