package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Book;
import com.example.demo.model.Patron;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BookControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    BookService bs;

    @Test
    void findBookById() {
        Optional<Book> obook = Optional.of(new Book("java", "sam", 2017, true, "tty5"));
        long id = 4;
        Mockito.when(bs.findById(Mockito.anyLong())).thenReturn(obook);
        ResponseEntity<Book> rese = restTemplate.getForEntity("/api/books/" + id, Book.class);
        assertThat(rese.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void findAllBooks() {
        Optional<Book> obook = Optional.of(new Book());
        List<Book> books = new ArrayList<Book>();
//		long id=4;
        Mockito.when(bs.finadAllBooks()).thenReturn(books);
        ResponseEntity<List> rese = restTemplate.getForEntity("/api/books", List.class);
        assertThat(rese.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


    @Test
    void addBook() {

        Book oBook = new Book();
//		long id=4;
        Mockito.when(bs.save(Mockito.any())).thenReturn(oBook);
        ResponseEntity<Book> rese = restTemplate.postForEntity("/api/books", oBook, Book.class);
        assertThat(rese.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
