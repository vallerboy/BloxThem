package pl.oskarpolak.blox.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.oskarpolak.blox.models.UserEntity;
import pl.oskarpolak.blox.models.forms.RegisterForm;
import pl.oskarpolak.blox.models.repositories.UserRepository;

import java.util.Optional;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class UserService {

    @Autowired
    UserRepository userRepository;

    private UserEntity userData;
    private boolean isLogin;

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

        if(loggedUser.isPresent()){
            isLogin = true;
            userData = loggedUser.get();
        }
        return loggedUser.isPresent();
    }

    public UserEntity getUserData() {
        return userData;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void logout(){
        isLogin = false;
        userData = null;
    }
}
