package com.example.exercise_repository.Controller;

import com.example.exercise_repository.Model.User;
import com.example.exercise_repository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
         List list =userService.findAll();

        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("/AddUser")
    public ResponseEntity AddUser(@RequestBody @Valid User user , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        userService.save(user);
        return ResponseEntity.status(200).body("Added successfully");
    }

    @PutMapping("/UpdateUser/{id}")
    public ResponseEntity UpdateUser(@PathVariable Integer id , @RequestBody @Valid User user , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body("Updated successfully");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);
        return ResponseEntity.status(200).body("deleted successfully");
    }
    @GetMapping("/login/{password}/{userName}")
    public ResponseEntity login(@PathVariable String password, @PathVariable String userName) {
        User user = userService.findByPasswordAndUsername(password, userName);
        return ResponseEntity.status(200).body("user login successfully");
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity getByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);

        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/findByRole/{role}")
    public ResponseEntity findByRole(@PathVariable String role){
         userService.findByRole(role);
        return ResponseEntity.status(200).body(userService.findByRole(role));
    }
    @GetMapping("/findRange/{min}/{max}")
    public ResponseEntity findRange(@PathVariable Integer min,@PathVariable Integer max){
        List list = userService.findRang(min, max);
        return ResponseEntity.status(200).body(list);
    }






}
