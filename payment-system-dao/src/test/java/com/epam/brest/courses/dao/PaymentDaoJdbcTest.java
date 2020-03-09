package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.CustomerCard;
//import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
public class PaymentDaoJdbcTest {


    private final PaymentDao paymentDao;

    @Autowired
    public PaymentDaoJdbcTest(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Test
    public void shouldFindAllCards() {

        List<CustomerCard> customerCard = paymentDao.findAll();
        assertNotNull(customerCard);
        assertTrue(customerCard.size() > 0);
    }

}