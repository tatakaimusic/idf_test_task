CREATE SCHEMA IF NOT EXISTS production;

CREATE TABLE IF NOT EXISTS production.transactions
(
    id                 BIGSERIAL PRIMARY KEY,
    account_from       INT       NOT NULL,
    account_to         INT    NOT NULL,
    currency_shortname VARCHAR   NOT NULL,
    sum                DECIMAL   NOT NULL,
    expense_category   VARCHAR   NOT NULL,
    datetime           TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS production.limits
(
    id                 BIGSERIAL PRIMARY KEY,
    sum                DECIMAL   NOT NULL,
    datetime           TIMESTAMP NOT NULL,
    expense_category   VARCHAR   NOT NULL,
    currency_shortname VARCHAR   NOT NULL
);
