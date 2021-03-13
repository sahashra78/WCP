CREATE TABLE PrdCategories(
	categoryId int IDENTITY NOT NULL,
	categoryName varchar(50) NOT NULL,
	PRIMARY KEY (categoryId));

CREATE TABLE ProductList(
	productId int IDENTITY NOT NULL,
	productName varchar(255) NOT NULL,
	productPrice decimal NOT NULL,
	productDesc varchar(max) NOT NULL,
	productImage varchar(50) NOT NULL,
	categoryId int NOT NULL,
 	PRIMARY KEY (productId));

ALTER TABLE ProductList ADD CONSTRAINT 
	FKCategory FOREIGN KEY(categoryId) 
	REFERENCES PrdCategories(categoryId); 

INSERT INTO PrdCategories
	(categoryName)
	VALUES
	('Earphones');

INSERT INTO PrdCategories
	(categoryName)
	VALUES
	('Phones');

INSERT INTO PrdCategories
	(categoryName)
	VALUES
	('Laptops');

INSERT INTO ProductList
	(productName,productPrice,productDesc,productImage,categoryId)
	VALUES
	('Airpod',200,'Apple Airpods brand new, closed box','/Images/Airpod1',1);

INSERT INTO ProductList
	(productName,productPrice,productDesc,productImage,categoryId)
	VALUES
	('Logitech Keyboard',15.50,'Wireless logitech keyboard with batteries, open box','/Images/LogiKeyboard',3);

INSERT INTO ProductList
	(productName,productPrice,productDesc,productImage,categoryId)
	VALUES
	('Iphone 8',390.50,'Used Apple iphone 8 128 gb','/Images/iphone8',2);