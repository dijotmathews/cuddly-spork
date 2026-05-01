package com.dijo.appmania;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    private MockMvc mockMvc;

    ObjectMapper om = new ObjectMapper();
    ObjectWriter ow = om.writer();

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    Book r1 = new Book(1L, "book1", "auth1 ", "summary1");
    Book r2 = new Book(2L, "book2", "auth2 ", "summary2");
    Book r3 = new Book(3L, "book3", "auth3 ", "summary3");
    Book r4 = new Book(4L, "book4", "auth4 ", "summary4");
    Book r5 = new Book(5L, "book5", "auth5 ", "summary5");

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }


    @Test
    public void getAllRecords_success() throws Exception{
        List<Book> records = new ArrayList<>(Arrays.asList(r1, r2, r3, r4));
        Mockito.when(bookRepository.findAll()).thenReturn(records);


    }

}
