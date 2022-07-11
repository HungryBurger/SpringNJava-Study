package com.example.springnjavastudy.di;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ContainerServiceTest {
    BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
}