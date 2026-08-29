package com.eclothing.clothing.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.*;
import java.util.Optional;

@SpringBootApplication
@RestController
public class OptionalOfDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OptionalOfDemoApplication.class, args);
    }

    private final UserRepository userRepository;

    public OptionalOfDemoApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/{id}")
    public User getUserEndpoint(@PathVariable Long id) {
        return getUser(id).get(); // safe: getUser() guarantees non-empty Optional
    }

    /**
     * Fetches a User by id.
     * Optional.of() is safe here because orElseThrow() guarantees
     * 'user' is non-null before we reach this line.
     */
    public Optional<User> getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return Optional.of(user);
    }

    @Entity
    public static class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;

        protected User() {}

        public User(String name) {
            this.name = name;
        }

        public Long getId() { return id; }
        public String getName() { return name; }
    }

    public interface UserRepository extends JpaRepository<User, Long> {}
}
