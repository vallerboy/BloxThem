package pl.oskarpolak.blox.controllers.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.oskarpolak.blox.models.forms.RegisterForm;
import pl.oskarpolak.blox.models.services.UserService;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    UserService userService;


    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity addUser(@RequestBody RegisterForm registerForm){
        if(userService.isUserExistByLogin(registerForm.getLogin())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("login is busy");
        }
        userService.registerUser(registerForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
