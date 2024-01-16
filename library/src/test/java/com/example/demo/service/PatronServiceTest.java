package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Book;
import com.example.demo.model.Patron;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.PatronRepo;

@SpringBootTest
class PatronServiceTest {
    @Autowired
    PatronService ps;

    @MockBean
    PatronRepo patronRepo;

    @Test
    void findByIdNotFound() {

        Mockito.when(patronRepo.findById(Mockito.anyLong())).thenReturn(null);

        Optional<Patron> patron = ps.findById(5);

        /*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*//*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*//*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*/assertEquals(null, patron);
    }


    @Test
    void findByIdFound() {
        Optional<Patron>  opatron = Optional.of(new Patron());
        Mockito.when(patronRepo.findById(Mockito.anyLong())).thenReturn(opatron);

        Optional<Patron> patron = ps.findById(5);
        assertEquals(true, patron.isPresent());

    }
}
