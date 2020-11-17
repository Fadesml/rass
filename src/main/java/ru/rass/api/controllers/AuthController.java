package ru.rass.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.rass.api.models.Worker;
import ru.rass.api.payload.request.LoginRequest;
import ru.rass.api.payload.request.SignupRequest;
import ru.rass.api.payload.response.JwtResponse;
import ru.rass.api.payload.response.MessageResponse;
import ru.rass.api.repository.WorkerRepository;
import ru.rass.api.security.jwt.JwtUtils;
import ru.rass.api.security.services.UserDetailsImpl;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;

	private final WorkerRepository workerRepository;

	private final PasswordEncoder encoder;

	private final JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, WorkerRepository workerRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.workerRepository = workerRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println(1);
		System.out.println(loginRequest.toString());
		System.out.println(encoder.encode(loginRequest.getPassword()));
		System.out.println(workerRepository.findByUsername(loginRequest.getUsername()).get().toString());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		System.out.println(2);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		System.out.println(3);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		System.out.println(userDetails.toString());
		System.out.println(userDetails.getAuthorities().toString());
		return ResponseEntity.ok(JwtResponse.builder()
                                            .setToken(jwt)
                                            .setId(userDetails.getId())
                                            .setUsername(userDetails.getUsername())
                                            .setEmail(userDetails.getEmail())
                                            .setRole("test")
                                            .build());
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (workerRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (workerRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new worker's account
		Worker worker = Worker.builder()
							.setUsername(signUpRequest.getUsername())
							.setFirstName(signUpRequest.getFirstName())
							.setLastName(signUpRequest.getLastName())
							.setMiddleName(signUpRequest.getMiddleName())
							.setEmail(signUpRequest.getEmail())
							.setPassword(encoder.encode(signUpRequest.getPassword()))
							.build();

		System.out.println(worker.toString());


		workerRepository.save(worker);

		return ResponseEntity.ok(new MessageResponse("Worker registered successfully!"));
	}
}
