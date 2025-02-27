package com.example.project1.library;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> getAllLibrary(){
        return libraryRepository.findAll();
    }

    public Library getLibraryById(long id) {
        return libraryRepository.findById(id).orElse(null);
    }

    public void addNewLibrary(Library library) {
        Optional<Library> libraryByAuthor=
                libraryRepository.findLibraryByAuthor(library.getAuthor());
        if(libraryByAuthor.isPresent()) {
            throw new IllegalArgumentException("Author already exists");
        }
    libraryRepository.save(library);}

    public void deleteLibrary(Long libraryId) {
        boolean exists = libraryRepository.existsById(libraryId);
        if (!exists) {
            throw new IllegalArgumentException(
                    "Library with id " + libraryId + " does not exist");
        }
        libraryRepository.deleteById(libraryId);
    }


    @Transactional
    public void updateLibrary(Long libraryId, String title) {
        Library library = libraryRepository.findById(libraryId).
                orElseThrow(()-> new IllegalArgumentException(
                        "Library with id " + libraryId + " does not exist"
                ));
        if (title != null &&
                title.length()>0 &&
                !Objects.equals(library.getTitle(), title)) {
            library.setTitle(title);

        }
    }
}
