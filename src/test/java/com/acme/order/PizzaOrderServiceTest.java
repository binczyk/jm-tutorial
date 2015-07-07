package com.acme.order;

<<<<<<< HEAD
import java.sql.Savepoint;
import java.util.Random;

import javax.xml.crypto.Data;

import org.junit.Assert;
import org.junit.Before;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
=======
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
>>>>>>> upstream/master

public class PizzaOrderServiceTest {

	private PizzaOrderService pizzaOrderService;
	private MailSender mailSender;
	private OrderDatabase orderDatabase;
	private OrderFactory orderFactory;
	private DeliveryTimeService deliveryTimeService;
<<<<<<< HEAD
	private MessageTemplateService messageTemplateService;
=======
	private MessageTemplateService messageTemplate;
>>>>>>> upstream/master

	@Before
	public void init() {
		mailSender = Mockito.mock(MailSender.class);
		orderDatabase = Mockito.mock(OrderDatabase.class);
		orderFactory = Mockito.mock(OrderFactory.class);
		deliveryTimeService = Mockito.mock(DeliveryTimeService.class);
<<<<<<< HEAD
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
=======
		messageTemplate = Mockito.mock(MessageTemplateService.class);
		pizzaOrderService = new PizzaOrderService(mailSender, orderDatabase,
				orderFactory, deliveryTimeService, messageTemplate);
	}

	@Test
	public void cancelledOrderShouldBePersistedAndEmailShoudlBeSent() {
		// given
		String pizzaOrderId = "fake_id";
		PizzaOrder givenPizzaOrder = givenPizzaOrder();
		// stub
		OrderCanceledTemplate template = Mockito
				.mock(OrderCanceledTemplate.class);
		Mockito.when(orderDatabase.get(Mockito.anyString())).thenReturn(
				givenPizzaOrder);
		Mockito.when(messageTemplate.getCancelTemplate()).thenReturn(template);
		// when
		pizzaOrderService.cancelOrder(pizzaOrderId);
		// then
		Assert.assertTrue(givenPizzaOrder.isCancelled());
		ArgumentCaptor<String> sentEmailAddress = ArgumentCaptor
				.forClass(String.class);
		Mockito.verify(mailSender).send(Mockito.any(Template.class),
				sentEmailAddress.capture());
		Assert.assertTrue(sentEmailAddress.getValue().equals(
				givenPizzaOrder.getEmail()));

		ArgumentCaptor<PizzaOrder> savedPizzaOrder = ArgumentCaptor
				.forClass(PizzaOrder.class);
		Mockito.verify(orderDatabase).save(savedPizzaOrder.capture());
		
		Assert.assertTrue(savedPizzaOrder.getValue().equals(givenPizzaOrder));
>>>>>>> upstream/master

	}

	private PizzaOrder givenPizzaOrder() {
		Customer customer = givenCustomer();
<<<<<<< HEAD
		PizzaType pizzaType = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, pizzaType);
=======
		PizzaType type = Mockito.mock(PizzaType.class);
		PizzaOrder givenOrder = new PizzaOrder(customer, type);
>>>>>>> upstream/master
		return givenOrder;
	}

	private Customer givenCustomer() {
<<<<<<< HEAD
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


=======
		// String customerEmail = "fake_email";
		Customer customer = new Customer();
		return customer;
	}
>>>>>>> upstream/master
}
