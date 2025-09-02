package com.codigo.spring_boot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReniecResponse {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("first_last_name")
    private String firstLastName;
    @JsonProperty("second_last_name")
    private String secondLastName;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("document_number")
    private String documentNumber;
}
// data transfer object