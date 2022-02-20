package com.kodilla.kodillawebflux;

import reactor.core.publisher.Flux;

public class FirstFluxCheck {
    public static void main(String[] args) {
        BookDto b1 = new BookDto("Title1", "Author1", 2000);
        BookDto b2 = new BookDto("Title2", "Author2", 2001);
        Flux<BookDto> bookFlux = Flux.just(b1, b2);
        bookFlux = bookFlux.concatWith(Flux.error(new Exception("Test exception")));
        bookFlux.subscribe(System.out::println, FirstFluxCheck::handleException);
    }

    private static void handleException(Throwable e) {
        System.out.println("There was an error: " + e);
    }
}
