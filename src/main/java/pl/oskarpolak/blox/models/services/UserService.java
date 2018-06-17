package pl.oskarpolak.blox.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.blox.models.UserEntity;
import pl.oskarpolak.blox.models.forms.RegisterForm;
import pl.oskarpolak.blox.models.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean isUserExistByLogin(String login){
        return userRepository.existsByLogin(login);
    }

    public boolean registerUser(RegisterForm registerForm){
        UserEntity newUser = new UserEntity();
        newUser.setHasAdmin(false);
        newUser.setPassword(registerForm.getPassword());
        newUser.setLogin(registerForm.getLogin());

        userRepository.save(newUser);
        return true;
    }


    public boolean loginUser(String login, String password){
        Optional<UserEntity> loggedUser =
                userRepository.findByLoginAndPassword(login, password);

        //tutaj logika uwietrzlnienia
        return loggedUser.isPresent();
    }
}
