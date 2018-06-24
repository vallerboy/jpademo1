package pl.oskarpolak.jpademo1.models.services;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.oskarpolak.jpademo1.models.UserEntity;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, scopeName = "session")
@Data
public class UserService {
    private boolean isLogin;
    private UserEntity user;
}
