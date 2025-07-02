package com.example.legacy;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class PriceFacadeTest {
    @Spy
    PriceFacade facade = new PriceFacade();
    @Test
    public void testTaxThrowsException_returnsFallback() throws Exception {
        PriceCalculator calculatorSpy = spy(facade.getCalculator());
        doThrow(new ArithmeticException()).when(calculatorSpy).getPriceWithTax(100);
        java.lang.reflect.Field field = PriceFacade.class.getDeclaredField("calculator");
        field.setAccessible(true);
        field.set(facade, calculatorSpy);
        int result = facade.getPrice(100);
        assertEquals(999, result);
        reset(calculatorSpy);
        field.set(facade, calculatorSpy);
        int realResult = facade.getPrice(100);
        assertNotEquals(999, realResult);
    }
}
