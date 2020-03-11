package com.epam.brest.courses.webapp;

import com.epam.brest.courses.model.CustomerCard;
import com.epam.brest.courses.model.Operation;
import com.epam.brest.courses.service.OperationService;
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
 * Operations controller.
 */
@Controller
public class OperationsController {
    private final OperationService operationService;

    @Autowired
    public OperationsController(OperationService operationService) {
        this.operationService = operationService;
    }

    //Full Operations List
    @GetMapping(value = "/operations")
    public final String operations(Model model) {

        model.addAttribute("operations", operationService.findAll());
        return "operations";
    }


    /* Update operation.
     */
    @PostMapping(value = "/operations/{id}")
    public String updateOperation(Operation operation) {

            this.operationService.update(operation);
            return "success msg";
        }

    /**
     * Delete operation.
     *
     * @return view name
     */
    @GetMapping(value = "/operations/{id}/delete")
    public final String deleteOperationById(@PathVariable Integer id, Model model) {

        operationService.delete(id);
        return "success msg";
    }
    /**
     * Edit operation.
     *
     */
//    @GetMapping(value = "/operations/{id}")
//    public final String gotoEditEmployeePage(@PathVariable Integer id, Model model) {
//
//        Optional<Operation> optionalOperation = operationService.findById(id);
//        if (optionalOperation.isPresent()) {
//            model.addAttribute("operation", optionalOperation.get());
//            return "employee";
//        } else {
//            return "Error msg";
//        }
//    }
}
