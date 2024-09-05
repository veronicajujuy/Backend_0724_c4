package dh.backend.clinica.dto.request;

import dh.backend.clinica.utils.GsonProvider;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoRequestDto {
    @NotNull(message = "El codigo de paciente no debe ser nulo")
    private Integer paciente_id;
    @NotNull(message = "El codigo de odontologo no debe ser nulo")
    private Integer odontologo_id;
    @NotNull(message = "La fecha no debe estar vacia")
    private String fecha;
    @Override
    public String toString() {
        return GsonProvider.getGson().toJson(this);
    }
}
