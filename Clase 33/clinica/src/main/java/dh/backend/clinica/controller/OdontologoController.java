package dh.backend.clinica.controller;

import dh.backend.clinica.entity.Odontologo;
import dh.backend.clinica.service.IOdontologoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {
    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Odontologo> agregarOdontologo(@Valid @RequestBody Odontologo odontologo){
//        @RequestBody(description = "Ejemplo de odontólogo",
//                content = @Content(
//                        examples = @ExampleObject(
//                                name = "example",
//                                summary = "Ejemplo de creación de odontólogo",
//                                value = "{ \"numeroMatricula\": \"1162224567\", \"nombre\": \"Juan\", \"apellido\": \"Guerra\" }"
//                        )
//                )
        // aca jackson convierte el objeto JSON a un objeto Java "paciente"
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        Optional<Odontologo> odontologo = odontologoService.buscarPorId(id);
        if(odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
