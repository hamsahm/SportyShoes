INSERT INTO PERSON (id, username, password, is_registered) VALUES
(10, 'User10', 'User10@1234', true),
(20, 'User20', 'User20@1234', true),
(30, 'User30', 'User30@1234', true),
(40, 'User40', 'User40@1234', false);

INSERT INTO CATEGORY (id, name) VALUES 
(10, 'Kids'),
(20, 'Men'),
(30, 'Women');

INSERT INTO PRODUCT (id, name, size, category_id, price, is_available) VALUES 
(10, 'Adidas Shoes', '7', 20,'500', true ),
(20, 'Sketchers', '4', 10, '1000', false),
(30, 'Nike', '6', 30, 600, true);

INSERT INTO ORDERS (order_id, user_id, order_amount, ordered_date,category_id ) VALUES
(1,10,500,sysdate(),10),
(2,20,1000,sysdate(),10),
(3,30, 5000, sysdate(),10),
(4,10,500,sysdate(),20),
(5,20,500,sysdate(),20),
(6,30,500,sysdate(),20),
(7,10,500,sysdate(),30),
(8,20,500,sysdate(),30),
(9,30,500,sysdate(),30);