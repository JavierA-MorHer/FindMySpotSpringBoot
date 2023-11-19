package com.pagos.apirest.Pago;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/pago")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @PostMapping("/create")
    public void createPago(@RequestBody Pago pago)
    {
        pagoService.createPago(pago);

    }

    @GetMapping("/users")
    public List<Pago> getAllUsers(){
        return pagoService.getAllPagos();
    }

    @GetMapping("/user/{id}")
    public Optional<Pago> getPagoById(@PathVariable Integer id){
        return pagoService.getPagoById(id);
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
