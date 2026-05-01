package com.dijo.appmania;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping
    public List<Book> getAllBooks()  {
        return bookRepository.findAll();
    }

    @GetMapping(value = "{id}")
    public Book getBookById(@PathVariable(value = "id") Long id) {
        return bookRepository.findById(id).get();
    }


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return  bookRepository.save(book);

    }


    @PutMapping
    public Book updateBook(@RequestBody Book book) throws NotFoundException {
        if(book == null || book.getId() == null) {
            throw new NotFoundException("No book given to find");
        }

        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if(!optionalBook.isPresent()) {
            throw new NotFoundException("The given book does not exist");
        }

        Book existingBook = optionalBook.get();
        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setSummary(book.getSummary());

        return bookRepository.save(existingBook);
    }
}
