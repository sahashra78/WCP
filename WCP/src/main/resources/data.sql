INSERT INTO category (category_name) VALUES	('Earphones');

INSERT INTO category (category_name) VALUES	('Phones');

INSERT INTO category (category_name) VALUES	('Laptops');

INSERT INTO product	(product_name,price,description,image)	VALUES	('Airpod',200,'Apple Airpods brand new, closed box','/Images/Airpod1');

INSERT INTO product	(product_name,price,description,image)	VALUES	('Logitech Keyboard',15.50,'Wireless logitech keyboard with batteries, open box','/Images/LogiKeyboard');

INSERT INTO product	(product_name,price,description,image)	VALUES	('Iphone 8',390.50,'Used Apple iphone 8 128 gb','/Images/iphone8');


INSERT INTO category_product_list (category_category_id, product_list_product_id) VALUES (1,1);
INSERT INTO category_product_list (category_category_id, product_list_product_id) VALUES (3,2);
INSERT INTO category_product_list (category_category_id, product_list_product_id) VALUES (2,3);