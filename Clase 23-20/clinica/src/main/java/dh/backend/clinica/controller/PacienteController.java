package dh.backend.clinica.controller;

import dh.backend.clinica.entity.Paciente;
import dh.backend.clinica.service.IPacienteService;
import dh.backend.clinica.service.impl.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private IPacienteService pacienteService;

    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    //POST
    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    //PUT
    @PutMapping("/modificar")
    public ResponseEntity<String>  modificarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> pacienteEncontrado = pacienteService.buscarPorId(paciente.getId());
        if(pacienteEncontrado.isPresent()){
            pacienteService.modificarPaciente(paciente);
            String jsonResponse = "{\"mensaje\": \"El paciente fue modificado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Integer id){
        Optional<Paciente>  pacienteEncontrado = pacienteService.buscarPorId(id);
        if(pacienteEncontrado.isPresent()) {
            pacienteService.eliminarPaciente(id);
            String jsonResponse = "{\"mensaje\": \"El paciente fue eliminado\"}";
            return ResponseEntity.ok(jsonResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //GET
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Paciente>  buscarPorId(@PathVariable Integer id){
        Optional<Paciente>  pacienteEncontrado = pacienteService.buscarPorId(id);
        if(pacienteEncontrado.isPresent()) {
            return ResponseEntity.ok(pacienteEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //GET
    @GetMapping("/buscartodos")
    public ResponseEntity<List<Paciente>>  buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping("/buscarApellidoNombre/{apellido}/{nombre}")
    public ResponseEntity<List<Paciente>> buscarApellido(@PathVariable String apellido, @PathVariable String nombre){
        return ResponseEntity.ok(pacienteService.buscarPorApellidoyNombre(apellido, nombre));
    }

    @GetMapping("/buscarApellido/{parte}")
    public ResponseEntity<List<Paciente>> buscarParteApellido(@PathVariable String parte){
        return ResponseEntity.ok(pacienteService.buscarPorUnaParteApellido(parte));
    }

}
