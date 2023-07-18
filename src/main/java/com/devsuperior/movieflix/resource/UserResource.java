package com.devsuperior.movieflix.resource;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO>findByLoggerdUser() {
        UserDTO dto = userService.findByLoggerdUser();
        return ResponseEntity.ok(dto);
    }
}
