INSERT INTO customerCard (customerCard_id, customerCard_type) VALUES (0, 'VISA', '1234', 15, 10, false);
INSERT INTO customerCard (customerCard_id, customerCard_type) VALUES (1, 'Maestro', '2345', 15, 10, false);
INSERT INTO customerCard (customerCard_id, customerCard_type) VALUES (2, 'UnionPay', '3342', 15, 10, false);

INSERT INTO operation (operation_id, description, operation_date, operation_cost, customerCard_id)
VALUES (1, 'test', CURRENT_TIMESTAMP, 15, 1);

INSERT INTO operation (operation_id, description, operation_date, operation_cost, customerCard_id)
VALUES (2, 'test1', CURRENT_TIMESTAMP, 15, 2);

INSERT INTO operation (operation_id, description, operation_date, operation_cost, customerCard_id)
VALUES (3, 'test2', CURRENT_TIMESTAMP, 15, 0);

INSERT INTO operation (operation_id, description, operation_date, operation_cost, customerCard_id)
VALUES (4, 'test3', CURRENT_TIMESTAMP, 15, 1);

INSERT INTO employee (operation_id, description, operation_date, operation_cost, customerCard_id)
VALUES (5, 'test4', CURRENT_TIMESTAMP, 15, 2);
