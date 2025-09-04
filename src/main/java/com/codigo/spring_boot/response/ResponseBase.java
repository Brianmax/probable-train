package com.codigo.spring_boot.response;

import com.codigo.spring_boot.entity.AvionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class ResponseBase {
    private int codigo;
    private String mensaje;
    private Optional data;
}
