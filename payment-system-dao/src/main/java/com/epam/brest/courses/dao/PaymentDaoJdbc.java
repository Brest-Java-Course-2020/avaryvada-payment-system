package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.CustomerCard;
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

public class PaymentDaoJdbc implements PaymentDao {

//    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentDaoJdbc.class);


    private final CustomerCardRowMapper customerCardRowMapper = new CustomerCardRowMapper();

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PaymentDaoJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<CustomerCard> findAll() {

//        LOGGER.trace("findAll()");
        return namedParameterJdbcTemplate.query(
                "SELECT customerCard_id, customerCard_type, customerCard_block, customerCard_number," +
                        "customerCard_expense, customerCard_balance  FROM customerCard ORDER BY customerCard_type",
                customerCardRowMapper);
    }

    @Override
    public Optional<CustomerCard> findById(Integer customerCardId) {

//        LOGGER.debug("findById(id:{})", customerCardId);
        SqlParameterSource namedParameters = new MapSqlParameterSource("customerCard_id", customerCardId);

        List<CustomerCard> results = namedParameterJdbcTemplate.query(
                "SELECT customerCard_id, customerCard_type, customerCard_balance," +
                        "customerCard_number, customerCard_expense, customerCard_block FROM customerCard WHERE customerCard_id = :customerCard_id",
                namedParameters, customerCardRowMapper);

        return Optional.ofNullable(DataAccessUtils.uniqueResult(results));
    }


    @Override
    public Integer create(CustomerCard customerCard) {

//        LOGGER.debug("create(CustomerCard:{})", customerCard);
        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("customerCard_type", customerCard.getCustomerCardType());
        params.addValue("customerCard_balance", customerCard.getCustomerCardBalance());
        params.addValue("customerCard_number", customerCard.getCustomerCardNumber());
        params.addValue("customerCard_expense", customerCard.getCustomerCardExpense());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(

                "INSERT INTO customerCard (customerCard_type, " +
                        "customerCard_balance, " +
                        "customerCard_number, customerCard_expense, customerCard_block) VALUES (" +
                        ":customerCard_type, :customerCard_balance, :customerCard_number, :customerCard_expense, false)",
                params, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public int update(CustomerCard customerCard) {

//        LOGGER.debug("update(customerCard:{})", customerCard);

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("customerCard_id", customerCard.getCustomerCardId());
        params.addValue("customerCard_block", customerCard.getCustomerCardBlock());

        //TODO add all fields in query

        return namedParameterJdbcTemplate.update(
                "UPDATE customerCard SET customerCard_block = :customerCard_block" +
                        " WHERE customerCard_id = :customerCard_id",
                params);
    }

    @Override
    public int delete(Integer customerCardId) {

//        LOGGER.debug("delete(customerCardId:{})", customerCardId);
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("customerCard_id", customerCardId);
        return namedParameterJdbcTemplate.update(
                "DELETE FROM customerCard WHERE customerCard_id = :customerCard_id",
                params);
    }


    private class CustomerCardRowMapper implements RowMapper<CustomerCard> {

        @Override
        public CustomerCard mapRow(ResultSet resultSet, int i) throws SQLException {
            CustomerCard customerCard = new CustomerCard();
            customerCard.setCustomerCardId(resultSet.getInt("customerCard_id"));
            customerCard.setCustomerCardType(resultSet.getString("customerCard_type"));
            customerCard.setCustomerCardBlock(resultSet.getBoolean("customerCard_block"));
            customerCard.setCustomerCardNumber(resultSet.getInt("customerCard_number"));
            customerCard.setCustomerCardExpense(resultSet.getBigDecimal("customerCard_expense"));
            customerCard.setCustomerCardBalance(resultSet.getBigDecimal("customerCard_balance"));
            return customerCard;
        }

    }
}
