package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.PaymentDao;
import com.epam.brest.courses.model.CustomerCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerCard> findAll() {
        return paymentDao.findAll();
    }

    @Override
    public Optional<CustomerCard> findById(Integer CustomerCardId) {
        return paymentDao.findById(CustomerCardId);
    }

    @Override
    public Integer create(CustomerCard customerCard) {
        return paymentDao.create(customerCard);
    }

    @Override
    public int update(CustomerCard customerCard) {
        return paymentDao.update(customerCard);
    }

    @Override
    public int delete(Integer customerCardId) {
        return paymentDao.delete(customerCardId);
    }
}
