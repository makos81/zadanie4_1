package com.kodilla.kodillawebflux.controller;

import com.kodilla.kodillawebflux.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class BookDtoController {

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<BookDto> getBookDto(){
        return Flux.just(
                new BookDto("book1", "author1", 2001),
                new BookDto("book2", "author2", 2002),
                new BookDto("book3", "author3", 2004),
                new BookDto("book4", "author4", 2005)
        ).delayElements(Duration.ofSeconds(2))
                .log();
    }
}
