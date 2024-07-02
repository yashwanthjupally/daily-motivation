package com.example.daily_Motivation;
import com.example.daily_Motivation.Entity.Motivational;
import com.example.daily_Motivation.Repository.MotivationalRepository;
import com.example.daily_Motivation.Service.MotivationalService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class MotivationalServiceTest {

    @Autowired
    private MotivationalService service;

    @Autowired
    private MotivationalRepository repository;

    @AfterEach
    @BeforeEach
    void deleteAllItems() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("find a given Devotional by its Id")
    void findATodoItemById() {
        // find a specific TodoItem by its id
        Motivational devo = new Motivational();
        devo.setQuote("foo");
        devo.setAuthor("bar");
        devo.setContent("test");

        devo = service.save(devo);

        Optional<Motivational> testItem = repository.findById(devo.getId());
        assertEquals(testItem.isPresent(), true);
        assertEquals(testItem.get().getId(), devo.getId());
    }

    @Test
    @DisplayName("finding all Devotionals succeeds")
    void getAllDevotionalItems() {

        Motivational item1 = new Motivational();
        item1.setContent("motive 1");

        item1 = service.save(item1);

        Motivational item2 = new Motivational();
        item2.setContent("motive 2");

        item2 = service.save(item2);

        Iterable<Motivational> items = repository.findAll();
        List<Motivational> list = new ArrayList<>();
        items.iterator().forEachRemaining(list::add);
        assertNotEquals(list.size(), 0);
        assertEquals(list.size(), 2);
        assertEquals(list.get(0).getId(), item1.getId());
        assertEquals(list.get(1).getId(), item2.getId());
    }

    @Test
    @DisplayName("saving a valid motivational succeeds")
    void savingAValidDevotionalSucceeds() {
        Motivational item = new Motivational();
        item.setContent("todo item1");

        item = service.save(item);
        assertNotEquals(item.getId(), null);
    }

    @Test
    @DisplayName("finding today's motivational succeeds")
    void getTodaysDailyDevotionalSucceeds() {
        Motivational item = new Motivational();
        item.setContent("motivational 1");
        LocalDate today = LocalDate.now();
        item.setPublishedAt(today);

        item = service.save(item);

        Optional<Motivational> testItem = service.getDaily();
        assertEquals(testItem.isPresent(), true);
        assertEquals(testItem.get().getId(), item.getId());

    }

}