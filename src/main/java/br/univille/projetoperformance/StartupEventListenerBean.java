package br.univille.projetoperformance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projetoperformance.model.UserModel;
import br.univille.projetoperformance.repository.UserRepository;


@Component
public class StartupEventListenerBean {
    @Autowired
    private UserRepository usuarioRepository;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(usuarioRepository.findByName("user") == null) {
            UserModel user = new UserModel();
            user.setEmail("email");
            user.setPassword("user");
            user.setRole("USER");
            usuarioRepository.save(user);
        }

    }
}