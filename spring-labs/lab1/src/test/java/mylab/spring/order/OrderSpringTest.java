package mylab.spring.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
    @Autowired private ShoppingCart shoppingCart;
    @Autowired private OrderService orderService;

    @Test
    public void shoppingCartBeanIsInjected() {
        assertNotNull(shoppingCart);
        assertEquals(2, shoppingCart.getProducts().size());
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
    }

    @Test
    public void orderServiceBeanIsInjected() {
        assertNotNull(orderService);
        assertNotNull(orderService.getShoppingCart());
        assertSame(shoppingCart, orderService.getShoppingCart());
        assertEquals(950000, orderService.calculateOrderTotal());
    }
}