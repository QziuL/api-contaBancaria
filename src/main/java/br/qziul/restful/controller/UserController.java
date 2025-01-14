package br.qziul.restful.controller;

import br.qziul.restful.Service.UserService;
import br.qziul.restful.dto.UserDTO;
import br.qziul.restful.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        User newUser = userService.create(userDTO);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(newUser.getId())
                        .toUri();
        return ResponseEntity.created(location).body(newUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteById(id));

        /*  = caso o retorno seja boolean =
            (userService.deleteById(id))
            ? new ResponseEntity<>(HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         */
    }
}
