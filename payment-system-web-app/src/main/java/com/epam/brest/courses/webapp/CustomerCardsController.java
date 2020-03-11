package com.epam.brest.courses.webapp;

import com.epam.brest.courses.model.CustomerCard;
import com.epam.brest.courses.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Customer Cards controller.
 */
@Controller

public class CustomerCardsController {

    private final PaymentService paymentService;

    @Autowired
    public CustomerCardsController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Update card - Block card.
     */
    @PostMapping(value = "/CustomerCards/{id}")
    public String updateCustomerCard(CustomerCard customerCard) {

        this.paymentService.update(customerCard);

        return "Success Message";
    }

    /**
     * Add new card into storage.
     *
     */
    @PostMapping(value = "/CustomerCards")
    public String addDepartment( CustomerCard customerCard) {

            this.paymentService.create(customerCard);
            return "Success Message";

    }

    /**
     * Delete Card.
     *
     */
    @GetMapping(value = "/CustomerCards/{id}/delete")
    public final String deleteDepartmentById(@PathVariable Integer id, Model model) {

        paymentService.delete(id);
        return "Success Message";
    }

}

