package com.epam.brest.courses.dao;

import com.epam.brest.courses.model.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationDao {

    /**
     * Find all Operations.
     *
     * @return Operations list.
     */

    List<Operation> findAll();

    /**
     * Find Operation by Id.
     *
     * @param  operationId -  Id.
     * @return Operation
     */

    Optional<Operation> findById(Integer operationId);

    /**
     * Persist new  operation.
     *
     * @param operation .
     * @return persisted operation id.
     */
    Integer create(Operation operation);

    /**
     * Update operation.
     *
     * @param operation .
     * @return number of updated records in the database.
     */
    int update(Operation operation);

    /**
     * Delete operation.
     *
     * @param operationId .
     * @return number of updated records in the database.
     */
    int delete(Integer operationId);

}
