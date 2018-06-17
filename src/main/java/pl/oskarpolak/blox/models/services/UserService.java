package pl.oskarpolak.blox.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oskarpolak.blox.models.UserEntity;
import pl.oskarpolak.blox.models.forms.RegisterForm;
import pl.oskarpolak.blox.models.repositories.UserRepository;

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
}
