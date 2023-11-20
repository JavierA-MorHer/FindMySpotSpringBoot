package com.pagos.apirest.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface PagoRepository extends JpaRepository <Pago, Integer> {

    @Query("SELECT p FROM Pago p WHERE p.id_Entrada = :id_Entrada")
    ArrayList<?> findByIdEntrada(@Param("id_Entrada") Integer id_Entrada); 
}
