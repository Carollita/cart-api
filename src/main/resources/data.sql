INSERT INTO restaurant (id, zip_code, address_description, name) VALUES
(1L, '13610230', 'Rua Padre Julião, 1451 - Centro, Leme - SP', 'Bar do Izão'),
(2L, '13610070', 'Rua Joaquim Mourão, 145 - Centro, Leme - SP', 'Tribo do Açaí');

INSERT INTO customer (id, zip_code, address_description, name) VALUES
(1L, '13610190', 'Rua Joaquim Mourão, 444 - Centro, Leme - SP', 'Carolina');

INSERT INTO product (id, product_available, name, unit_price, restaurant_id) VALUES
(1L, true, 'Bauru', 22.0, 1L),
(2L, true, 'Refrigerante Lata', 5.0, 1L),
(3L, true, 'Suco Natural', 8.0, 1L),
(4L, true, 'Creme de Pitaya', 8.0, 2L),
(5L, true, 'Pote açaí 2 litros', 35.0, 2L);

INSERT INTO cart (id, payment_methods, closed, total, customer_id) VALUES
(1L, 0, false, 0.0, 1L);