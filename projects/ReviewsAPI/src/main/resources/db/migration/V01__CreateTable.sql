CREATE TABLE products (
  productID INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  info VARCHAR(300) NOT NULL,
  PRIMARY KEY (productID)
);

create table reviews(
    reviewID int(11) not null auto_increment,
    productID int(11) not null,
    content varchar(300) not null,
    primary key (reviewID),
    foreign key (productID) references products (productID)
);