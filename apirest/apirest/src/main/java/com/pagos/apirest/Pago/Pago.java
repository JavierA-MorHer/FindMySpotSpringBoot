package com.pagos.apirest.Pago;

import java.sql.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pago {

    @Id
    @GeneratedValue
    private Integer id_Pago;
    @Basic
    private Integer id_Usuario;
    private Integer id_Entrada;
    private Integer Total;
    
}


