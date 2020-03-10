DROP TABLE IF EXISTS customerCard;
CREATE TABLE customerCard
(
    customerCard_id      INT NOT NULL AUTO_INCREMENT,
    customerCard_type    VARCHAR(20) NOT NULL,
    customerCard_number  INT NOT NULL,
    customerCard_balance BIGINT NOT NULL,
    customerCard_expense BIGINT NOT NULL,
    customerCard_block   boolean NOT NULL,

    PRIMARY KEY (customerCard_id)
);

DROP TABLE IF EXISTS operation;
CREATE TABLE operation
(
    operation_id    INT NOT NULL AUTO_INCREMENT,
    description     VARCHAR(255) NOT NULL,
    operation_date  DATE NOT NULL,
    operation_cost  BIGINT NOT NULL,
    customerCard_id INT NOT NULL ,

    PRIMARY KEY (operation_id),
    FOREIGN KEY (customerCard_id) REFERENCES customerCard (customerCard_id)
);