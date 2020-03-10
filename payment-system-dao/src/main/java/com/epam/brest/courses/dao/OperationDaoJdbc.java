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

    private final OperationRowMapper customerCardRowMapper = new OperationRowMapper();

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public OperationDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Operation> findAll(){

//        LOGGER.trace("findAll()");
        return namedParameterJdbcTemplate.query(
                "SELECT operation_id, operation_cost, operation_date, customerCard_id," +
                        "description FROM operation ORDER BY operation_date",
                customerCardRowMapper);
    }

    @Override
    public Optional<Operation> findById(Integer operationId) {

//        LOGGER.debug("findById(id:{})", customerCardId);
        SqlParameterSource namedParameters = new MapSqlParameterSource("operation_id", operationId);

        List<Operation> results = namedParameterJdbcTemplate.query(
                "SELECT operation_id, operation_cost, operation_date, customerCard_id," +
                        "description FROM operation WHERE operation_id = :operation_id",
                namedParameters, customerCardRowMapper);

        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }


    @Override
    public Integer create(Operation operation) {

//        LOGGER.debug("create(CustomerCard:{})", customerCard);
        MapSqlParameterSource params = new MapSqlParameterSource();
//todo if date empty - today
        params.addValue("operation_cost", operation.getOperation_cost());
        params.addValue("operation_date", operation.getOperation_date());
        params.addValue("customerCard_id", operation.getCustomerCard_id());
        params.addValue("description", operation.getDescription());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(

                "INSERT INTO operation (operation_cost, " +
                        "operation_date, " +
                        "customerCard_id, description) VALUES (" +
                        ":operation_cost, :operation_date, :customerCard_id, :description)",
                params, keyHolder);

        return keyHolder.getKey().intValue();

    }

    @Override
    public int update(Operation operation) {
        //        LOGGER.debug("update(customerCard:{})", customerCard);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("operation_id", operation.getOperation_id());
        params.addValue("description", operation.getDescription());

        return namedParameterJdbcTemplate.update(
                "UPDATE operation SET description = :description" +
                        " WHERE operation_id = :operation_id",
                params);
    }

    @Override
    public int delete(Integer operationId) {
//      LOGGER.debug("delete(customerCardId:{})", customerCardId);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("operation_id", operationId);
        return namedParameterJdbcTemplate.update(
                "DELETE FROM operation WHERE operation_id = :operation_id",
                params);
    }

    private class OperationRowMapper implements RowMapper<Operation> {

        @Override
        public Operation mapRow(ResultSet resultSet, int i) throws SQLException {
            Operation operation = new Operation();
            operation.setDescription(resultSet.getString("description"));
            operation.setCustomerCard_id(resultSet.getInt("customerCard_id"));
            operation.setOperation_date(resultSet.getDate("operation_date"));
            operation.setOperation_cost(resultSet.getBigDecimal("operation_cost"));
            operation.setOperation_id(resultSet.getInt("operation_id"));
            return operation;
        }

    }
}
