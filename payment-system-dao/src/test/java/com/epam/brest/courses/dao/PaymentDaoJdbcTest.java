package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.CustomerCard;
//import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
class PaymentDaoJdbcTest {


    private final PaymentDao paymentDao;

    @Autowired
    PaymentDaoJdbcTest(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Test
    void shouldFindAllCards() {

        List<CustomerCard> customerCard = paymentDao.findAll();
        assertNotNull(customerCard);
        assertTrue(customerCard.size() > 0);
    }

    @Test
    void shouldFindById() {

        CustomerCard customerCard = new CustomerCard();
        customerCard.setCustomerCardType("VISA");
        customerCard.setCustomerCardNumber(2345);
        customerCard.setCustomerCardExpense(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBalance(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBlock(false);

        Integer id = paymentDao.create(customerCard);

        Optional<CustomerCard> optionalCard = paymentDao.findById(id);

        Assertions.assertTrue(optionalCard.isPresent());
        assertEquals(optionalCard.get().getCustomerCardId(), id);
        assertEquals(optionalCard.get().getCustomerCardType(), customerCard.getCustomerCardType());
        assertEquals(optionalCard.get().getCustomerCardBalance(), customerCard.getCustomerCardBalance());
    }

    @Test
    void shouldCreateCard() {

        CustomerCard customerCard = new CustomerCard();
        customerCard.setCustomerCardType("VISA");
        customerCard.setCustomerCardNumber(2345);
        customerCard.setCustomerCardExpense(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBalance(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBlock(false);

        Integer id = paymentDao.create(customerCard);

        assertNotNull(id);
    }

    @Test
    void shouldUpdateCard() {

        CustomerCard customerCard = new CustomerCard();
        customerCard.setCustomerCardType("VISA");
        customerCard.setCustomerCardNumber(2345);
        customerCard.setCustomerCardExpense(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBalance(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBlock(false);

        Integer id = paymentDao.create(customerCard);

        assertNotNull(id);
        //null check
        Optional<CustomerCard> optionalCard = paymentDao.findById(id);
        Assertions.assertTrue(optionalCard.isPresent()); //assert if not null

        optionalCard.get().setCustomerCardBlock(true);

        int result = paymentDao.update(optionalCard.get());

        Assert.assertEquals(1, result);

        Optional<CustomerCard> updatedCard = paymentDao.findById(id);
        Assertions.assertTrue(updatedCard.isPresent());
        assertEquals(updatedCard.get().getCustomerCardId(), id);
        assertEquals(updatedCard.get().getCustomerCardBlock(), true);
    }

    @Test
    void shouldDeleteCard() {

        CustomerCard customerCard = new CustomerCard();
        customerCard.setCustomerCardType("VISA");
        customerCard.setCustomerCardNumber(2345);
        customerCard.setCustomerCardExpense(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBalance(BigDecimal.valueOf(5));
        customerCard.setCustomerCardBlock(false);

        Integer id = paymentDao.create(customerCard);

        List<CustomerCard> beforeDeleteCustomerCard = paymentDao.findAll();
        assertNotNull(beforeDeleteCustomerCard);

        int result = paymentDao.delete(id);

        Assert.assertEquals(1, result);

        List<CustomerCard> afterDeleteCustomerCard = paymentDao.findAll();
        assertNotNull(afterDeleteCustomerCard);

        Assert.assertEquals(beforeDeleteCustomerCard.size() - 1, afterDeleteCustomerCard.size());
    }

}