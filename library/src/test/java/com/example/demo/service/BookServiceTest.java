package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class BookServiceTest {
    @Autowired
    BookService bs;

    @MockBean
    BookRepo bookRepo;

    @Test
    void findByIdNotFound() {

        Mockito.when(bookRepo.findById(Mockito.anyLong())).thenReturn(null);

        Optional<Book> book = bs.findById(5);

        /*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*//*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*//*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*/assertEquals(null, book);
    }


    @Test
    void findByIdFound() {
        Optional<Book> obook =	Optional.of(new Book("sam", "training", 2009, true, "ae33d"));
        Mockito.when(bookRepo.findById(Mockito.anyLong())).thenReturn(obook);

        Optional<Book> book = bs.findById(5);
        assertEquals(true, book.isPresent());

    }
}
