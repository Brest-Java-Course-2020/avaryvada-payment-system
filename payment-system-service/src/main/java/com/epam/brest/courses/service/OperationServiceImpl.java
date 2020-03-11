package com.epam.brest.courses.service;

import com.epam.brest.courses.dao.OperationDao;
import com.epam.brest.courses.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OperationServiceImpl implements OperationDao {

    private final OperationDao operationDao;

    public OperationServiceImpl(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    @Override
    public List<Operation> findAll() {
        return operationDao.findAll();
    }

    @Override
    public Optional<Operation> findById(Integer operationId) {
        return operationDao.findById(operationId);
    }

    @Override
    public Integer create(Operation operation) {
        return operationDao.create(operation);
    }

    @Override
    public int update(Operation operation) {
        return operationDao.update(operation);
    }

    @Override
    public int delete(Integer operationId) {
        return operationDao.delete(operationId);
    }
}
