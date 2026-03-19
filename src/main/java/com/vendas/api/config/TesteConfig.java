package com.vendas.api.config;

import com.vendas.api.entities.User;
import com.vendas.api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TesteConfig implements CommandLineRunner {

    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "igor schmitz", "igor@gmail.com", "41 996053764", "123456",null );
        User u2 = new User(null, "jessica schmitz", "jessica@gmail.com", "41 996053764", "123456",null );
        User u3 = new User(null, "suva silva", "suva@gmail.com", "41 996053764", "123456",null );
        User u4 = new User(null, "lucao alves", "lucao@gmail.com", "41 996053764", "123456",null );

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));




    }
}
