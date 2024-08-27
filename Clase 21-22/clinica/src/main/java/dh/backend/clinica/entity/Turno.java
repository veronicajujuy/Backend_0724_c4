package dh.backend.clinica.entity;

import dh.backend.clinica.utils.GsonProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;

    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
