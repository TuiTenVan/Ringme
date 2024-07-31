package com.exampleProject.Restaurant.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class AbstractDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 7213600440729202783L;
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("created_date")
    private Date createdDate;

    @JsonProperty("modified_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date modifiedDate;

}
