INSERT INTO transactions (account_from, account_to, currency_shortname, sum, expense_category, datetime)
VALUES (1234567891, 1234567892, 'RUB', 250, 'service', '2023-03-26 00:00:00'),
       (1234567891, 1234567892, 'KZT', 1000, 'service', '2023-03-27 00:00:00'),
       (1234567891, 1234567892, 'RUB', 250, 'product', '2023-08-01 00:00:00'),
       (1234567891, 1234567892, 'KZT', 1000, 'product', '2023-08-02 00:00:00'),
       (1234567891, 1234567892, 'KZT', 100, 'product', '2023-08-04 00:00:00');

INSERT INTO limits (sum, datetime, expense_category, currency_shortname)
VALUES (1000, '2023-03-25 00:00:00', 'service', 'USD'),
       (1000, '2023-03-25 00:00:00', 'product', 'USD'),
       (1500, '2023-08-03 00:00:00', 'product', 'USD');