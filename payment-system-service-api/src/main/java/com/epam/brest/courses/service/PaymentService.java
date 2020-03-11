package com.epam.brest.courses.service;

import com.epam.brest.courses.model.CustomerCard;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    /**
     * Find all Customer Cards.
     *
     * @return Customer Cards list.
     */

    List<CustomerCard> findAll();

    /**
     * Find Customer Cards by Id.
     *
     * @param  CustomerCardId Customer Card Id.
     * @return Customer Card
     */

    Optional<CustomerCard> findById(Integer CustomerCardId);

    /**
     * Persist new  Customer Card.
     *
     * @param customerCard Customer Card.
     * @return persisted Customer Card id.
     */
    Integer create(CustomerCard customerCard);

    /**
     * Update Customer Card.
     *
     * @param customerCard Customer Card.
     * @return number of updated records in the database.
     */
    int update(CustomerCard customerCard);

    /**
     * Delete Customer Card.
     *
     * @param customerCardId Customer card id.
     * @return number of updated records in the database.
     */
    int delete(Integer customerCardId);

}