package com.example.project1.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LibraryRepository
        extends JpaRepository<Library, Long> {


    @Query("SELECT s FROM Library s WHERE s.author = ?1")
    Optional<Library> findLibraryByAuthor(String author);
}
