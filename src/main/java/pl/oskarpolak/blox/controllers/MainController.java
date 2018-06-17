package pl.oskarpolak.blox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.blox.models.UserEntity;
import pl.oskarpolak.blox.models.repositories.UserRepository;

@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        UserEntity userEntity = new UserEntity();
        userEntity.setHasAdmin(true);
        userEntity.setLogin("oskar");
        userEntity.setPassword("costam");

        userRepository.de(userEntity);
        return "Stworzono usera!";
    }


}
