package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class OperationDaoJdbc implements OperationDao {

    //private final OperationRowMapper customerCardRowMapper = new OperationRowMapper();

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public OperationDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Operation> findAll() {
        return null;
    }

    @Override
    public Optional<Operation> findById(Integer operationId) {
        return Optional.empty();
    }

    @Override
    public Integer create(Operation operation) {
        return null;
    }

    @Override
    public int update(Operation operation) {
        return 0;
    }

    @Override
    public int delete(Integer operationId) {
        return 0;
    }
}
