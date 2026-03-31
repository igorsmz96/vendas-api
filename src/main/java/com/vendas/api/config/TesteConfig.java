package com.vendas.api.config;

import com.vendas.api.entities.Address;
import com.vendas.api.entities.User;
import com.vendas.api.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
@AllArgsConstructor
public class TesteConfig implements CommandLineRunner {

    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
       List<Address> addresses = new ArrayList<>();
       Address a1 = new Address(null,"jaime rodrigues", "1550", "capao raso", "curitiba", "parana", "81150-130",null,null,null);
       addresses.add(a1);

        User u1 = new User(null, "igor schmitz", "igor@gmail.com", "41 996053764", "123456",addresses );
        User u2 = new User(null, "jessica schmitz", "jessica@gmail.com", "41 996053764", "123456",null );
        User u3 = new User(null, "suva silva", "suva@gmail.com", "41 996053764", "123456",null );
        User u4 = new User(null, "lucao alves", "lucao@gmail.com", "41 996053764", "123456",null );

        a1.setUser(u1);

        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));




    }
}
