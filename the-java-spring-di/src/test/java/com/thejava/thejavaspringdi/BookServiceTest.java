package com.thejava.thejavaspringdi;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired BookService bookService;

    @Test
    public void di() {
        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);
    }
}