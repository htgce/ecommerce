CREATE TABLE IF NOT EXISTS User
(
    ID        Long        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    FIRSTNAME varchar(50),
    LASTNAME  varchar(50),
    EMAIL     varchar(50) NOT NULL,
    PASSWORD  varchar(50) NOT NULL
);

INSERT INTO User (FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES ('TUGCE', 'KAHVECİ', 'tugce.ozkaptan@gmail.com', 'Test123');