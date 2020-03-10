package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Operation;
//import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
class OperationDaoJdbcTest {


    private final OperationDao operationDao;

    @Autowired
    OperationDaoJdbcTest(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    @Test
    void shouldFindAllOperations() {

        List<Operation> opertion = operationDao.findAll();
        assertNotNull(opertion);
        assertTrue(opertion.size() > 0);
    }

    @Test
    void shouldFindById() {

        Operation operation = new Operation();

        operation.setDescription("TestOperation");
        operation.setOperation_cost(BigDecimal.valueOf(5));
        operation.setOperation_date(new Date());
        operation.setCustomerCard_id(1);
        Integer id = operationDao.create(operation);

        Optional<Operation> optionalOperation = operationDao.findById(id);
        Assertions.assertTrue(optionalOperation.isPresent());

        assertEquals(optionalOperation.get().getOperation_id(), id);
        assertEquals(optionalOperation.get().getOperation_cost(), operation.getOperation_cost());
    }

    @Test
    void shouldCreateOperation() {

        Operation operation = new Operation();
        operation.setDescription("TestOperation");
        operation.setOperation_cost(BigDecimal.valueOf(5));
        operation.setOperation_date(new Date());
        operation.setCustomerCard_id(1);

        Integer id = operationDao.create(operation);

        assertNotNull(id);
    }

    @Test
    void shouldUpdateOperation() {

        Operation operation = new Operation();
        operation.setDescription("TestOperation");
        operation.setOperation_cost(BigDecimal.valueOf(5));
        operation.setOperation_date(new Date());
        operation.setCustomerCard_id(1);

        Integer id = operationDao.create(operation);

        assertNotNull(id);
        //null check
        Optional<Operation> optionalOperation = operationDao.findById(id);
        Assertions.assertTrue(optionalOperation.isPresent()); //assert if not null

        optionalOperation.get().setDescription("TestOperationUpdate");

        int result = operationDao.update(optionalOperation.get());

        assertTrue(1 == result);

        Optional<Operation> updatedOperation = operationDao.findById(id);
        Assertions.assertTrue(updatedOperation.isPresent());
        assertEquals(updatedOperation.get().getOperation_id(), id);
        assertEquals(updatedOperation.get().getDescription(), "TestOperationUpdate");
    }

    @Test
    void shouldDeleteOperation() {

        Operation operation = new Operation();
        operation.setDescription("TestOperation");
        operation.setOperation_cost(BigDecimal.valueOf(5));
        operation.setOperation_date(new Date());
        operation.setCustomerCard_id(1);

        Integer id = operationDao.create(operation);

        List<Operation> beforeDeleteOperations = operationDao.findAll();
        assertNotNull(beforeDeleteOperations);

        int result = operationDao.delete(id);

        Assert.assertEquals(1, result);

        List<Operation> afterDeleteOperations = operationDao.findAll();
        assertNotNull(afterDeleteOperations);

        Assert.assertEquals(beforeDeleteOperations.size() - 1, afterDeleteOperations.size());
    }

}
