package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Book;
import com.example.demo.model.Borrowing;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.BorrowingRepo;


@SpringBootTest
class BorrowingServiceTest {


    @Autowired

    BorrowingService brs;
    @MockBean
    BorrowingRepo borrowingRepo;

    @Test
    void findByIdNotFound() {

        Mockito.when(borrowingRepo.findById(Mockito.anyLong())).thenReturn(null);

        Borrowing br = brs.findById(5);

        /*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*//*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*//*~~(Unable to find runtime dependencies beginning with: 'junit-jupiter-api')~~>*/assertEquals(null, br);
    }


    @Test
    void findByPatronIdAndBookIdNotFound() {
        Mockito.when(borrowingRepo.findByPatronIdAndBookId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(null);
        Optional<Borrowing> br = brs.findByPatronIdAndBookId(2, 5);
        assertEquals(null, br);
    }

    @Test
    void findByPatronIdAndBookIdFound() {
        Optional<Borrowing> obr =	Optional.of(new Borrowing("martin", "training"));
        Mockito.when(borrowingRepo.findByPatronIdAndBookId(Mockito.anyLong(), Mockito.anyLong())).thenReturn(obr);
        Optional<Borrowing> br = brs.findByPatronIdAndBookId(2, 5);
//		Optional<Book>book=brs.findById(5);
        assertEquals(true, br.isPresent());

    }
}

