package com.example.project1.library;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/library")
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping
    public List<Library> getLibrary(){

        return libraryService.getLibrary();
    }

    @PostMapping
    public void registerNewLibrary(@RequestBody Library library){
        libraryService.addNewLibrary(library);
    }

    @DeleteMapping(path = "{libraryId}")
    public void deleteLibrary(
            @PathVariable("libraryId")  Long libraryId){
        libraryService.deleteLibrary(libraryId);
    }

    @PutMapping(path= "{libraryId")
    public void updateLibrary(
        @PathVariable("libraryId") Long libraryId,
        @RequestParam (required = false) String title) {
        libraryService.updateStudent(libraryId, title);
    }
}
