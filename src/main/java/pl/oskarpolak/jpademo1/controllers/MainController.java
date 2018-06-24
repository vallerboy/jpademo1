package pl.oskarpolak.jpademo1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.jpademo1.models.UserEntity;
import pl.oskarpolak.jpademo1.models.repositories.UserRepository;

import java.util.Optional;

@Controller
public class MainController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        Optional<UserEntity> downData = userRepository.findById(1);

        return downData.orElseThrow(IllegalStateException::new).toString();
    }


}
