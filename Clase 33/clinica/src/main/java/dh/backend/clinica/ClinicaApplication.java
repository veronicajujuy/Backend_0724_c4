package dh.backend.clinica;

import dh.backend.clinica.entity.Role;
import dh.backend.clinica.entity.Usuario;
import dh.backend.clinica.repository.IUsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(IUsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder){
		return args -> {
			if(usuarioRepository.findByEmail("admin@admin.com").isEmpty()){
				Usuario admin = new Usuario();
				admin.setNombre("admin");
				admin.setApellido("admin");
				admin.setEmail("admin@admin.com");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setRol(Role.ADMIN);
				usuarioRepository.save(admin);
			}
		};
	}

}
