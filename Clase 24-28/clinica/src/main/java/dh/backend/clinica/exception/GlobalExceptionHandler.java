package dh.backend.clinica.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> recursoNoEncontrado(ResourceNotFoundException e, HttpServletRequest request){
        ApiError apiError = new ApiError(
            request.getRequestURI(),
            e.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            ZonedDateTime.now(),
            List.of()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> requerimientoIncorrecto(BadRequestException e, HttpServletRequest request){
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                ZonedDateTime.now(),
                List.of()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    // Este codigo esta comentado porque si tienen errores, no les proporciona la suficiente información sobre el error
    // descomentar solo cuando este listo el backend

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiError> manejoGeneral(Exception e, HttpServletRequest request){
//        ApiError apiError = new ApiError(
//                request.getRequestURI(),
//                e.getMessage(),
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                ZonedDateTime.now(),
//                List.of()
//        );
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
//    }
}
