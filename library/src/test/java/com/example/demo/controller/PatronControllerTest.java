package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Book;
import com.example.demo.model.Patron;
import com.example.demo.service.BookService;
import com.example.demo.service.PatronService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PatronControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @MockBean
    PatronService ps;

    @Test
    void findPatronById() {
        Optional<Patron> opatron = Optional.of(new Patron());
        long id = 4;
        Mockito.when(ps.findById(Mockito.anyLong())).thenReturn(opatron);
        ResponseEntity<Patron> rese = restTemplate.getForEntity("/api/patrons/" + id, Patron.class);
        assertThat(rese.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void addPatron() {

        Patron opatron = new Patron();
//		long id=4;
        Mockito.when(ps.save(Mockito.any())).thenReturn(opatron);
        ResponseEntity<Patron> rese = restTemplate.postForEntity("/api/patrons", opatron, Patron.class);
        assertThat(rese.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void findAllPatrons() {

        List<Patron> patrons = new ArrayList<Patron>();
//		long id=4;
        Mockito.when(ps.finadAllPatrons()).thenReturn(patrons);
        ResponseEntity<List> rese = restTemplate.getForEntity("/api/patrons", List.class);
        assertThat(rese.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
