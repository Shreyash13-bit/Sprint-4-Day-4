package com.example.demo.controller;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookService bookService;
    @Test
    void testGetBookByIdSuccess() throws Exception {
        Book book = new Book(1L, "Test Book");
        given(bookService.getBookById(1L)).willReturn(book);
        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test Book"));
    }
    @Test
    void testGetBookByIdNotFound() throws Exception {
        given(bookService.getBookById(2L)).willThrow(new BookNotFoundException(2L));
        mockMvc.perform(get("/api/books/2"))
                .andExpect(status().isNotFound());
    }
}
