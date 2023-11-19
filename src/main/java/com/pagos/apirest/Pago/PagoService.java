package com.pagos.apirest.Pago;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public void createPago(Pago pago)
    {
        pagoRepository.save(pago);

    }

    public List<Pago> getAllPagos(){
        return pagoRepository.findAll();
    }

    public Optional<Pago> getPagoById(Integer id){
        return pagoRepository.findById(id);
    }

    public void editarPago(Integer id, Pago nuevoPago){
        Optional<Pago> pagoExistente = pagoRepository.findById(id);
        
        if(pagoExistente.isPresent()){
            Pago pago = pagoExistente.get();
            pago.setId_Usuario(nuevoPago.getId_Usuario());
            pago.setId_Entrada(nuevoPago.getId_Entrada());
            pago.setTotal(nuevoPago.getTotal());

            pagoRepository.save(pago);
        }
    }

    public void borrarPago(Integer id){
        pagoRepository.deleteById(id);
    }
    
}
