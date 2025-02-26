package com.example.project1.library;

import org.springframework.boot.CommandLineRunner;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class LibraryConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            LibraryRepository repository) {
        return args -> {
            Library mark = new Library(
                    "Markel Adventure's",
                    "Markel Gladney",
                    50
            );
            Library larry = new Library(
                    "Larrys Day Out",
                    "Tanner Allen",
                    100
            );
            Library kenny = new Library(
                    "Janice terrible day",
                    "Patrick Skeen",
                    75
            );
            repository.saveAll(
                    List.of(larry,kenny,mark)
            );

        };
    };
}
