# Assignment 4 - Context Isolation Integration Test

This test uses @SpringBootTest to load the full Spring context including web server and H2 DB.
The third-party dependency `PaymentGatewayClient` is mocked using @MockBean.
A real HTTP call is made using TestRestTemplate to POST /orders.

## Observation
Compared to @DataJdbcTest, full context test takes more time to start (due to web + full bean loading).
Use slicing when only testing persistence layer to improve speed.
