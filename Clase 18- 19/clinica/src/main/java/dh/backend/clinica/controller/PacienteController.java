package dh.backend.clinica.controller;

import dh.backend.clinica.model.Paciente;
import dh.backend.clinica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
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
        Paciente pacienteEncontrado = pacienteService.buscarPorId(paciente.getId());
        if(pacienteEncontrado!= null){
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
        Paciente pacienteEncontrado = pacienteService.buscarPorId(id);
        if(pacienteEncontrado!= null) {
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
        Paciente pacienteEncontrado = pacienteService.buscarPorId(id);
        if(pacienteEncontrado!= null) {
            return ResponseEntity.ok(pacienteEncontrado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //GET
    @GetMapping("/buscartodos")
    public ResponseEntity<List<Paciente>>  buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}
