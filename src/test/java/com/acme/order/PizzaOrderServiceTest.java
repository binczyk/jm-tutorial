package com.acme.order;

import java.sql.Savepoint;
import java.util.Random;

import javax.xml.crypto.Data;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

public class PizzaOrderServiceTest {

	private PizzaOrderService pizzaOrderService;
	private MailSender mailSender;
	private OrderDatabase orderDatabase;
	private OrderFactory orderFactory;
	private DeliveryTimeService deliveryTimeService;
	private MessageTemplateService messageTemplateService;

	@Before
	public void init() {
		mailSender = Mockito.mock(MailSender.class);
		orderDatabase = Mockito.mock(OrderDatabase.class);
		orderFactory = Mockito.mock(OrderFactory.class);
		deliveryTimeService = Mockito.mock(DeliveryTimeService.class);
		messageTemplateService = Mockito.mock(MessageTemplateService.class);

		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase, orderFactory, deliveryTimeService,
				messageTemplateService);
	}

	public void cancelleOrderShouldBePersistedAndEmailshouldBeSended() {
		// given
		String pizzaOrderId = "fake_id";
		PizzaOrder givenPizzaOrder = givenPizzaOrder();

		// stub
		OrderCanceledTemplate template = Mockito.mock(OrderCanceledTemplate.class);

		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(givenPizzaOrder);

		Mockito.when(messageTemplateService.getCancelTemplate()).thenReturn(template);
		// when
		pizzaOrderService.cancelOrder(pizzaOrderId);
		// then

		ArgumentCaptor<String> sendEmail = ArgumentCaptor.forClass(String.class);
		Assert.assertTrue(givenPizzaOrder.isCancelled());
		Mockito.verify(mailSender).send(Mockito.any(Template.class), Mockito.anyString());
		Assert.assertTrue(sendEmail.getValue().equals(givenPizzaOrder.getEmail()));
		Mockito.verify(orderDatabase).save(Mockito.any(PizzaOrder.class));
		ArgumentCaptor<String> sevedPizzaOrder = ArgumentCaptor.forClass(String.class);
		Assert.assertTrue(sevedPizzaOrder.getValue().equals(givenPizzaOrder));

	}

	private PizzaOrder givenPizzaOrder() {
		Customer customer = givenCustomer();
		PizzaType pizzaType = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, pizzaType);
		return givenOrder;
	}

	private Customer givenCustomer() {
		//String custormerEmaile = "email";
		Customer customer = new Customer();

		return customer;
	}

	public void createOrderTests() {
		// given
		Customer customer = givenCustomer();
		PizzaType pizzaType = Mockito.mock(PizzaType.class);
		
		PizzaOrder givenPizzaOrder = givenPizzaOrder();
		OrderFactory order = Mockito.mock(OrderFactory.class);
		
		Mockito.verify(deliveryTimeService).
					
	}


}
