package com.example.demo;

import com.example.demo.client.PaymentGatewayClient;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PaymentGatewayClient gateway;

    @Autowired
    private OrderRepository repository;

    @Test
    void testCreateOrder() {
        Order order = new Order(1L, "Keyboard");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Order> request = new HttpEntity<>(order, headers);

        var response = restTemplate.postForEntity("/orders", request, Order.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(gateway, times(1)).charge();
        assertTrue(repository.findById(1L).isPresent());
    }
}
