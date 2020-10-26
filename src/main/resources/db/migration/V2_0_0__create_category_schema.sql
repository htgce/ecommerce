CREATE TABLE IF NOT EXISTS Category
(
    ID     Long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    NAME   varchar(50),
    PARENT LONG,
    CONSTRAINT FKtng6hvelpjyy0n72f5eq93nq4 FOREIGN KEY (PARENT) REFERENCES Category
);

INSERT INTO Category(NAME, PARENT)
VALUES ('KADIN', 1);
INSERT INTO Category(NAME, PARENT)
VALUES ('ERKEK', 1);
INSERT INTO Category(NAME, PARENT)
VALUES ('COCUK', 1);

CREATE TABLE IF NOT EXISTS PRODUCT
(
    ID          Long NOT NULL AUTO_INCREMENT PRIMARY KEY,
    DESCRIPTION varchar(50),
    BRANDNAME   varchar(50),
    SIZE        varchar(8),
    AGE         varchar(8),
    PRICE       decimal,
    CATEGORY    LONG
);

alter table PRODUCT
    add constraint FKtng6hvelpjyy7el0f5eq93nq4 foreign key (CATEGORY) references Category;
