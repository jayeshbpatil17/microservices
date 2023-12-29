package com.patil.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;

@Entity
@Cacheable
public class ReactiveBook extends PanacheEntity {


    public String title;


    public String author;

    public static Uni<ReactiveBook> findByTitle(String title) {
        return find("title", title).firstResult();
    }

    public ReactiveBook() {
    }

    public ReactiveBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
