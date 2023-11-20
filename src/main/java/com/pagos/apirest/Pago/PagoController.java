package com.pagos.apirest.Pago;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;
    

    @PostMapping("/create")
    public ResponseEntity<Pago> createPago(@RequestBody Pago pago)
    {
        Pago nuevoPago = pagoService.createPago(pago);

         // Puedes ajustar el código de respuesta según tus necesidades
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);

    }

    @GetMapping("/list")
    public List<Pago> getAllUsers(){
        return pagoService.getAllPagos();
    }

    @GetMapping("/pago/{id}")
    public Optional<Pago> getPagoById(@PathVariable Integer id){
        return pagoService.getPagoById(id);
    }

     @GetMapping("/status/{id}")
    public Boolean getPagosByEntradaId(@PathVariable Integer id){
            if (pagoService.getPagosByEntradaId(id).isEmpty()) {
                return false;
            }else{
                return true;
            }
    }

    @PutMapping("/modify/{id}")
    public void editarPago(@RequestBody Pago pago, @PathVariable Integer id){
        pagoService.editarPago(id, pago);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePago(@PathVariable Integer id){
        pagoService.borrarPago(id);
    }

}
