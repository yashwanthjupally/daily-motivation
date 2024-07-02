package com.example.daily_Motivation.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "motivational")
public class Motivational {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    String quote;

    String author;

    String image_path;


    @Override
    public String toString() {
        return String.format("motivational{id=%d, image_path='%s', quote='%s', author='%s'}",
                id, image_path, quote, author);
    }
}
