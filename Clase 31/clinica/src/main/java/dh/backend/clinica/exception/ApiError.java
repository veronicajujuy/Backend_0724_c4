package dh.backend.clinica.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
    private String path;
    private String message;
    private int statusCode;
    private ZonedDateTime zonedDateTime;
    List<String> errors;
}
