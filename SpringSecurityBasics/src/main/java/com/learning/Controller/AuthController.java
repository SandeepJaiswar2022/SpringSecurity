package com.learning.Controller;

import com.learning.Configuration.AuthenticationRequest;
import com.learning.Configuration.AuthenticationResponse;
import com.learning.Configuration.AuthenticationService;
import com.learning.Configuration.RegisterRequest;
import com.learning.Exception.EmailAlreadyExists;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authService;


    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello World this is demo page");
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request) throws EmailAlreadyExists {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
