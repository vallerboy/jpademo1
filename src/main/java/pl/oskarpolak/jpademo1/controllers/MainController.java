package pl.oskarpolak.jpademo1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.jpademo1.models.UserEntity;
import pl.oskarpolak.jpademo1.models.repositories.UserRepository;
import pl.oskarpolak.jpademo1.models.services.UserService;

import java.util.Optional;

@Controller
public class MainController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user", userService);
        return "index";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("login") String login,
                           @RequestParam("password") String password,
                           @RequestParam("passwordRepeat") String passwordRepeat,
                           @RequestParam("email") String email,
                           Model model){
        if(!password.equals(passwordRepeat)){
            model.addAttribute("info", "Hasła się nie zgadzają!");
            return "register";
        }

        if(userRepository.existsByUsername(login)){
            model.addAttribute("info", "Nick zajety");
            return "register";
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(password);
        userEntity.setEmail(email);
        userEntity.setUsername(login);

        userRepository.save(userEntity);
        model.addAttribute("info", "Zarejestrowano");
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("login") String login,
                        @RequestParam("password") String password,
                        Model model){
        Optional<UserEntity> user = userRepository.findByUsernameAndPassword(login, password);

        if(user.isPresent()) {
            userService.setLogin(true);
            userService.setUser(user.get());
            return "redirect:/";
        }

        model.addAttribute("info", "Błędne dane!");
        return "login";
    }

}
