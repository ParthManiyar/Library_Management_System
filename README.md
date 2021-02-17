**DESCRIPTION OF PROJECT**

Our project is of Library Management System. We are considering the following specifications. The Library is an enterprise which contains book, periodicals and newspapers. These items are supplied to the library by supplier. One supplier supplies many items but one item can be supplied by only one supplier. A book can be written by one or more authors and one author can write many books. A single publisher can publish many books but one book can be published by only one publisher. The library has members belonging to two categories, namely- faculty and student. A faculty member can issue a maximum of 4 books and 2 periodicals. Whereas, a student member can issue a maximum of 2 books and 1 periodical. Every item can be issued by a member for a period of 7 days, after which a fine of Rs.5/day is levied on all the members. The newspapers are non-issuable items and can be picked up from the rack and read.

While removing a book/periodical, only its quantity updated and the remaining details still stay in the database. While removing a member, we check whether the member has all the fines paid and he/she does not possess any item of the library in his/her issue record.

While issuing a book or periodical, following conditions should be fulfilled: The member should be a valid member of the library, the item should be available in stock, the member should not possess the item already, and member should not exceed his /her issuable limits. While returning a book or periodical, fine needs to be calculated and payment needs to be made.

**ENTITY – RELATIONSHIP DIAGRAM**

![](RackMultipart20210217-4-1y7nb0x_html_1c0c714952295008.gif)

**TABLE DESIGN (DATA DICTIONARY)**

1. **SUPPLIER:**

CREATE TABLE supplier(supplier\_id INT PRIMIARY KEY, gst\_no VARCHAR(15), company\_name VARCHAR(30), contact VARCHAR(10),email\_id VARCHAR(30));

![](RackMultipart20210217-4-1y7nb0x_html_173f702c2ad1c3a7.png)

- **supplier\_id:** To avoid clashes, it is auto-incremented via procedures, therefore, it is &#39;INT&#39;. It depicts the unique id of the supplier.
- **gst\_no:** GST no is unique for every supplier in the market. It is a 15 digit number and so it is declared as VARCHAR(15) to limit the digits till 15 characters.
- **company\_name:** It describes the name of the company in words and therefore it is kept VARCHAR(30).
- **contact:** Mainly taking the mobile number as input so it is made VARCHAR(10), for 10 digits entry.
- **email\_id:** It will be unique for every supplier and it is limited to a maximum length of 30 characters.

1. **PUBLISHER:**

CREATE TABLE publisher(publisher\_id INT PRIMIARY KEY,company\_name VARCHAR(30));

![](RackMultipart20210217-4-1y7nb0x_html_75d14f47a8231ab9.png)

- **publisher\_id:** To avoid clashes, it is auto-incremented via procedures, therefore, it is &#39;INT&#39;. It depicts the unique id of the publisher.

- **company\_name:** It describes the name of the company in words, and so it is given VARCHAR(30).

1. **MEMBER:**

CREATE TABLE member(mem\_id INT PRIMIARY KEY, mem\_fname VARCHAR(20) not null,mem\_lname VARCHAR(20), mem\_type VARCHAR(3), no\_of\_books INT, no\_of\_perios INT);

![](RackMultipart20210217-4-1y7nb0x_html_af9128de43c54868.png)

- **mem\_id:** To avoid clashes, it is auto-incremented via procedures, therefore, it is &#39;INT&#39;. It depicts the unique id of the member.
- **mem\_fname:** Depicts the first name of the member, limited to 20 characters.
- **mem\_lname:** Depicts the last name of the member, limited to 20 characters.
- **mem\_type:** It depicts the type of member, namely- Faculty or Student, which is entered into VARCHAR(3) format as &#39;FAC&#39; and &#39;STU&#39; respectively.
- **no\_of\_books:** Depicts the number of books, that the member is currently issuing. The limit of number of books is given in the description for the respected type of member. It is updated for every issue and return by the member.
- **no\_of\_perios:** Depicts the number of periodicals, that the member is currently issuing. The limit of number of periodicals is given in the description for the respected type of member. It is updated for every issue and return by the member.

1. **BOOK:**

CREATE TABLE book(book\_id INT PRIMIARY KEY,isbn\_no VARCHAR(13), title VARCHAR(50) not null ,edition INT, publisher\_id INT REFERENCES publisher(publisher\_id),no\_of\_pages INT, no\_of\_copies INT, price FLOAT, rackno VARCHAR(3), deckno VARCHAR(3), supplier\_id INT REFERENCES supplier(supplier\_id));

![](RackMultipart20210217-4-1y7nb0x_html_683a45f48391e9f4.png)

- **book\_id:** To avoid clashes, it is auto-incremented via procedures, therefore, it is &#39;INT&#39;. It depicts the unique id of the book. All the books with the same ISBN, edition, publisher are registered in a single book\_id, and therefore, no\_of\_copies is stored as an attribute.
- **isbn\_no:** Depicts the ISBN number of the book, which differs for every new edition of the book and is different for different publishers. ISBN was 10 digit until December 2006 but is now of 13 digits so VARCHAR(13) is used as a limit.
- **title:** Depicts the name of the book, which is limited to 50 characters.
- **edition:** Depicts the edition of the book in number, therefore, it is kept &#39;INT&#39;.
- **publisher\_id:** Referred from the publisher table
- **no\_of\_pages:** Depicts the number of pages for the given book in terms of &#39;INT&#39;.
- **no\_of\_copies:** Depicts the number of copies of the same book, with same ISBN, currently available in the library. This attribute is updated as and when the book is issued or returned.
- **price:** Depicts the price of the book in terms of FLOAT numeric datatype.
- **rackno:** Depicts the location of the book in terms of the number of the rack which is taken as VARCHAR(3), where the first character is an alphabet – &#39;R&#39; which stands for rack and the next two characters stand for the number.
- **deckno:** Depicts the location of the book in terms of the number of the deck which is taken as VARCHAR(3), where the first character is an alphabet – &#39;D&#39; which stands for deck and the next two characters stand for the number.
- **supplier\_id:** Referred from the supplier table.

1. **PERIODICAL:**

CREATE TABLE periodical(perio\_id INT PRIMIARY KEY, title VARCHAR(30), perio\_type VARCHAR(3), no\_of\_copies INT, published\_date DATE, supplier\_id INT REFERENCES supplier(supplier\_id));

![](RackMultipart20210217-4-1y7nb0x_html_a4bf18b9d7e2feca.png)

- **perio\_id:** To avoid clashes, it is auto-incremented via procedures, therefore, it is &#39;INT&#39;. It depicts the unique id of the periodical. All the periodicals with the same title, type and published date are registered in a single perio\_id, and therefore, no\_of\_copies is stored as an attribute.
- **title:** Depicts the title of the periodical, which is limited to 30 characters.

- **perio\_type:** Depicts the type of the periodical. Basically, there exits three types of periodicals, namely – Popular, Trade and Scholarly which is denoted by VARCHAR(3) as &#39;POP&#39;, &#39;TRA&#39;, &#39;SCH&#39;.

- **no\_of\_copies:** Depicts the number of copies of the same periodical, with same title, type and published date, currently available in the library. This attribute is updated as and when the periodical is issued or returned.

- **published\_date:** Depicts the date when the periodical was published.
- **supplier\_id:** Referred from the supplier table.

1. **BOOK TRANSACTION:**

CREATE TABLE bookTrans(book\_id INT REFERENCES book(book\_id), mem\_id INT REFERENCES member(mem\_id),issue\_date DATE,due\_date DATE,return\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_4f368deea6a30f3b.png)

- **book\_id:** Referred from the book table.
- **mem\_id:** Referred from the member table.
- **issue\_date:** Depicts the date on which a particular book with the given book\_id is issued by a particular member with the given mem\_id.
- **due\_date:** Depicts the due date of the book, which is 7 days from the issue date. It gets registered as soon as an issue takes place.
- **return\_date:** Depicts the date of return of the particular book by a particular member. It gets registered as and when the book is returned and it is compared with the due\_date to generate the fine details if any.

1. **PERIODICAL TRANSACTION:**

CREATE TABLE periodicalTrans(perio\_id INT REFERENCES periodical(perio\_id), mem\_id INT REFERENCES member(mem\_id),issue\_date DATE,due\_date DATE,return\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_67f150ab3e480ae.png)

- **perio\_id:** Referred from the periodical table.
- **mem\_id:** Referred from the member table.
- **issue\_date:** Depicts the date on which a particular periodical with the given perio\_id is issued by a particular member with the given mem\_id.
- **due\_date:** Depicts the due date of the periodical, which is 7 days from the issue date. It gets registered as soon as an issue takes place.
- **return\_date:** Depicts the date of return of the particular periodical by a particular member. It gets registered as and when the periodical is returned and it is compared with the due\_date to generate the fine details if any.

1. **AUTHOR:**

CREATE TABLE author(author\_id INT PRIMIARY KEY,author\_name VARCHAR(30));

![](RackMultipart20210217-4-1y7nb0x_html_b5af825dc5cbeedc.png)

- **author\_id:** To avoid clashes, it is auto-incremented via procedures, therefore, it is &#39;INT&#39;. It depicts the unique id of the author.
- **author\_name:** Depicts the name of the author and is limited to 30 characters.

1. **BOOK AUTHOR:**

CREATE TABLE bookAuthor(book\_id INT REFERENCES book(book\_id),author\_id INT REFERENCES author(author\_id));

![](RackMultipart20210217-4-1y7nb0x_html_adc914320215c800.png)

- The tables acts as a **BRIDGE TABLE** between book and author table
- **Book\_id:** Referredd from book table.
- **Author\_id:** Referred from the author table.

1. **BOOK FINE:**

CREATE TABLE book\_fine(mem\_id INT REFERENCES member(mem\_id), book\_id INT REFERENCES book(book\_id), amount FLOAT, payment\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_2a84644d8f2c454b.png)

- **mem\_id:** Referred from the member table.
- **book\_id:** Referred from the book table.
- **amount:** Depicts the fine to be paid by the member on return of the book.
- **payment\_date:** Gets registered as the date when the payment is made. It can be the date of return or some other date when the payments is made. The possibility of the member not having enough money currently to pay the fine is considered, therefore, while removing a member, it is checked whether all the dues are filled or not using the value of the payment\_date.

1. **PERIODICAL FINE:**

CREATE TABLE perio\_fine(mem\_id INT REFERENCES member(mem\_id), perio\_id INT References periodical(perio\_id), amount FLOAT, payment\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_b6c48d3d43198301.png)

- **mem\_id:** Referred from the member table.
- **perio\_id:** Referred from the periodical table.
- **amount:** Depicts the fine to be paid by the member on return of the periodical.
- **payment\_date:** Gets registered as the date when the payment is made. It can be the date of return or some other date when the payments is made. The possibility of the member not having enough money currently to pay the fine is considered, therefore, while removing a member, it is checked whether all the dues are filled or not using the value of the payment\_date.

1. **NEWSPAPER:**

CREATE TABLE newspaper(title VARCHAR(30),published\_date DATE,no\_of\_copies INT,supplier\_id INT REFERENCES supplier(supplier\_id),PRIMIARY KEY(title,published\_date));

![](RackMultipart20210217-4-1y7nb0x_html_4a8c00e529d4c90c.png)

- **title:** Depicts the title of the newspaper depending on the publishing company, limited to 30 characters.
- **published\_date:** Depicts the date of the newspaper when published.
- **no\_of\_copies:** Registers the number of copies of the newspapers of the same title and same date.
- **supplier\_id:** Referred from the supplier table.

1. **BOOK TRANSACTION HISTORY:**

CREATE TABLE bookTransaction\_history(book\_id INT REFERENCES book(book\_id), mem\_id INT REFERENCES member(mem\_id),issue\_date DATE,due\_date DATE,return\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_6d0e28b2f8afc161.png)

- The table is just used to store the history of the book transactions made, so the data of bookTrans is transferred to this table at regular intervals, to maintain the history of the records. Attribute description remains the same.

1. **PERIODICAL TRANSACTION HISTORY:**

CREATE TABLE periodicalTransaction\_history(perio\_id INT REFERENCES periodical(perio\_id), mem\_id INT REFERENCES member(mem\_id),issue\_date DATE,due\_date DATE,return\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_672a293d60b41f8c.png)

- The table is just used to store the history of the periodical transactions made, so the data of periodicalTrans is transferred to this table at regular intervals, to maintain the history of the records. Attribute description remains the same.

1. **FETCH MEMBER:**

CREATE TABLE fetch\_member(mem\_id INT, mem\_fname VARCHAR(20), mem\_lname VARCHAR(20));

![](RackMultipart20210217-4-1y7nb0x_html_239f8d6b8eff57ac.png)

- This table is used as an **ASSISTANT TABLE** , which is not a part of the main ER Diagram. It is used to just fetch the member details from the member table using a procedure, while removing a member, in order to maintain convenience of search via first and last name.

1. **FETCH BOOK:**

CREATE TABLE fetch\_book(book\_id INT, isbn\_no VARCHAR(13), title VARCHAR(20), edition INT, publisher\_id INT, no\_of\_copies INT);

![](RackMultipart20210217-4-1y7nb0x_html_841d6a82330550e0.png)

- This table is used as an **ASSISTANT TABLE** , which is not a part of the main ER Diagram. It is used to just fetch the book details from the book table using a procedure, while removing a book, in order to maintain convenience of search via title of the book.

1. **FETCH PERIODICAL:**

CREATE TABLE fetch\_perio(perio\_id INT, title VARCHAR(30),perio\_type VARCHAR(20), no\_of\_copies INT, published\_date DATE);

![](RackMultipart20210217-4-1y7nb0x_html_b7d85c936813954a.png)

- This table is used as an **ASSISTANT TABLE** , which is not a part of the main ER Diagram. It is used to just fetch the periodical details from the periodical table using a procedure, while removing a periodical, in order to maintain convenience of search via the title of the periodical.

**STORED PROCEDURES**

1. **ADD MEMBER:**

DELIMITER $$

CREATE PROCEDURE add\_member(fname VARCHAR(20),lname VARCHAR(20), type VARCHAR(3))

BEGIN

DECLARE member\_name, member\_type VARCHAR(20);

DECLARE no, id INT;

SELECT MAX(mem\_no) INTO no FROM member;

IF no is not null THEN

SET id=no+1;

ELSE

SET id=1;

END IF;

SET member\_fname = fname;

SET member\_lname = lname;

SET member\_type = type;

INSERT INTO member VALUES(id,member\_fname,member\_lname,member\_type,0,0,0,0);

SELECT concat(&#39;Mr/Mrs/Miss. &#39; ,member\_name, &#39;, your membership id is &#39;, id);

END $$

1. **FETCH MEMBER:**

DELIMITER $$

CREATE PROCEDURE fetch\_member(mem\_fname\_ VARCHAR(20), mem\_lname\_ VARCHAR(20))

BEGIN

DELETE FROM fetch\_member;

INSERT INTO fetch\_member(mem\_id,mem\_fname,mem\_lname) (SELECT member.mem\_id, member.mem\_fname, member.mem\_lname FROM member WHERE lower(member.mem\_fname) = lower(mem\_fname\_) and lower(member.mem\_lname) = lower(mem\_lname\_));

SELECT \* FROM fetch\_member;

END $$

1. **REMOVE MEMBER:**

DELIMITER $$

CREATE PROCEDURE remove\_member(mem\_id\_ INT)

BEGIN

DELETE FROM member WHERE mem\_id = mem\_id\_;

END$$

1. **ADD BOOK:**

CREATE PROCEDURE add\_book(isbn\_no\_1 VARCHAR(13), title\_1 VARCHAR(20), edition\_1 INT, publisher\_id\_1 INT,no\_of\_pages\_1 INT, no\_of\_copies\_1 INT, price\_1 FLOAT)

BEGIN

DECLARE q INT;

DECLARE book\_id, no INT;

DECLARE nu VARCHAR(13);

SET nu := (SELECT isbn\_no FROM book WHERE isbn\_no=isbn\_no\_1);

IF isbn\_no\_1=nu THEN

SET q := (SELECT no\_of\_copies FROM book WHERE isbn\_no=isbn\_no\_1);

UPDATE book SET no\_of\_copies=no\_of\_copies\_1+q WHERE isbn\_no=isbn\_no\_1;

ELSE

SELECT MAX(book\_id) INTO no FROM book;

IF no is not null THEN

SET book\_id=no+1;

ELSE

SET book\_id=1;

END IF;

INSERT INTO book VALUES(book\_id,isbn\_no\_1,title\_1,edition\_1,publisher\_id\_1,no\_of\_pages\_1,no\_of\_copies\_1,price\_1);

END IF;

END $$

1. **FETCH BOOK:**

DELIMITER $$

CREATE PROCEDURE fetch\_book(title\_ VARCHAR(20))

BEGIN

DELETE FROM fetch\_book;

INSERT INTO fetch\_book (SELECT book.book\_id, book.isbn\_no, book.title, book.edition, book.publisher\_id, book.no\_of\_copies FROM book WHERE book.title = title\_);

SELECT \* FROM fetch\_book;

END $$

1. **REMOVE BOOK:**

DELIMITER $$

CREATE PROCEDURE remove\_book(book\_id\_ INT, qty INT)

BEGIN

UPDATE book SET no\_of\_copies = no\_of\_copies - qty WHERE book.book\_id = book\_id\_;

END $$

1. **ADD PERIODICAL:**

CREATE PROCEDURE add\_periodical(title\_1 VARCHAR(30), perio\_type\_1 VARCHAR(20), no\_of\_copies\_1 INT, published\_date\_1 date, supplier\_id\_1 INT)

BEGIN

DECLARE perio\_id\_1, no INT;

SELECT MAX(perio\_id) INTO no FROM periodical;

IF no is not null THEN

SET perio\_id\_1=no+1;

ELSE

SET perio\_id\_1=1;

END IF;

INSERT INTO periodical VALUES(perio\_id\_1,title\_1,perio\_type\_1,no\_of\_copies\_1,publisher\_date\_1,supplier\_id\_1);

END $$

1. **FETCH PERIODICAL:**

DELIMITER $$

CREATE PROCEDURE fetch\_perio(title\_ VARCHAR(30))

BEGIN

DELETE FROM fetch\_perio;

INSERT INTO fetch\_perio (SELECT periodical.perio\_id, periodical.title, periodical.perio\_type, periodical.no\_of\_copies, periodical.published\_date FROM periodical WHERE periodical.title = title\_);

SELECT \* FROM fetch\_perio;

END$$

1. **REMOVE PERIODICAL:**

DELIMITER $$

CREATE PROCEDURE remove\_perio(perio\_id\_ INT, qty INT)

BEGIN

IF(((SELECT periodical.no\_of\_copies FROM periodical WHERE periodical.perio\_id = perio\_id\_) - qty ) \&lt; 0) THEN

SELECT concat(&#39;Not enough periodicals available to DELETE the quantity mentioned. Number of periodicals available : &#39; , (SELECT periodical.no\_of\_copies FROM periodical WHERE periodical.perio\_id = perio\_id\_)) as Unsuccessful;

ELSEIF(((SELECT periodical.no\_of\_copies FROM periodical WHERE periodical.perio\_id = perio\_id\_) - qty ) \&gt;= 0) THEN

UPDATE periodical SET no\_of\_copies = no\_of\_copies - qty WHERE periodical.perio\_id = perio\_id\_;

SELECT concat(&#39;Periodicals removed successfully. Number of periodicals available : &#39; , (SELECT periodical.no\_of\_copies FROM periodical WHERE periodical.perio\_id = perio\_id\_) ) as Sucessful;

END IF;

END $$

1. **ADD NEWSPAPER:**

CREATE PROCEDURE add\_newspaper(title\_1 VARCHAR(30),published\_date\_1 DATE,no\_of\_copies\_1 INT,supplier\_id\_1 INT)

BEGIN

INSERT INTO newspaper VALUES(title\_1,published\_date\_1,no\_of\_copies\_1,supplier\_id\_1);

END$$

1. **ADD SUPPLIER**

CREATE PROCEDURE add\_supplier(gst\_no VARCHAR(30), company\_name VARCHAR(30), conatact\_no VARCHAR(10),email\_id VARCHAR(30))

BEGIN

DECLARE company\_name, gst\_no,email\_id VARCHAR(30);

DECLARE supplier\_id\_1, no INT;

SELECT MAX(supplier\_id) INTO no FROM supplier;

IF no is not null THEN

SET supplier\_id\_1=no+1;

ELSE

SET supplier\_id\_1=1;

END IF;

INSERT INTO supplier VALUES(supplier\_id\_1,gst\_no,company\_name,contact\_no,email\_id);

END $$

1. **ADD AUTHOR:**

CREATE PROCEDURE add\_author(author\_name1 VARCHAR(30), author\_name2 VARCHAR(30), author\_name3 VARCHAR(30))

BEGIN

DECLARE author\_id\_1, no INT;

SELECT MAX(author\_id) INTO no FROM author;

IF no is not null THEN

SET author\_id\_1=no+1;

ELSE

SET author\_id\_1=1;

END IF;

INSERT INTO author VALUES(author\_id\_1,author\_name1,author\_name2,author\_name3);

END $$

1. **ADD BOOKAUTHOR:**

CREATE PROCEDURE add\_bookauthor (book\_id\_1 INT,author\_id\_1 INT)

BEGIN

INSERT INTO bookauthor VALUES(book\_id\_1,author\_id\_1);

END$$

1. **ADD PUBLISHER:**

CREATE PROCEDURE add\_publisher(commpany\_name\_1 VARCHAR(30))

BEGIN

DECLARE publisher\_id\_1, no INT;

SELECT MAX(publisher\_id) INTO no FROM publisher;

IF no is not null THEN

SET publisher\_id\_1=no+1;

ELSE

SET publisher\_id\_1=1;

END IF;

INSERT INTO publisher VALUES(publisher\_id\_1,company\_name\_1);

END$$

1. **ISSUE BOOK:**

CREATE PROCEDURE issue\_book(book\_id\_1 INT,mem\_id\_1 INT)

BEGIN

INSERT INTO bookTrans VALUES(book\_id\_1,mem\_id\_1,SYSDATE(),SYSDATE()+7,NULL);

END $$

1. **ISSUE PERIODICAL:**

CREATE PROCEDURE issue\_perio(perio\_id\_1 INT,mem\_id\_1 INT)

BEGIN

INSERT INTO periodicalTrans VALUES(perio\_id\_1,mem\_id\_1,SYSDATE(),SYSDATE()+7,NULL);

END $$

1. **MAKE BOOK FINE PAYMENTS:**

DELIMITER $$

CREATE PROCEDURE makebook\_payment(mem\_id\_ INT, book\_id\_ INT)

BEGIN

UPDATE book\_fine SET payment\_date = now() WHERE mem\_id = mem\_id\_ and book\_id = book\_id\_;

END $$

1. **MAKE PERIODICAL FINE PAYMENTS:**

DELIMITER $$

CREATE PROCEDURE makeperio\_payment(mem\_id\_ INT, book\_id\_ INT)

BEGIN

UPDATE perio\_fine SET payment\_date = now() WHERE mem\_id = mem\_id\_ and book\_id = book\_id\_;

END $$

**FUNCTIONS**

1. **RETURN BOOK:**

DELIMITER $$

CREATE FUNCTION return\_book(book\_id\_ INT, mem\_id\_ INT) RETURNS FLOAT DETERMINISTIC

BEGIN

DECLARE date\_today, due\_date DATE;

DECLARE days INT;

SET date\_today = current\_date();

SELECT bookTrans.due\_date FROM bookTrans where bookTrans.book\_id = book\_id\_ AND bookTrans.mem\_id = mem\_id\_ INTO due\_date;

update bookTrans set return\_date = date\_today where bookTrans.book\_id = book\_id\_ AND bookTrans.mem\_id=mem\_id\_;

update book set no\_of\_copies = no\_of\_copies + 1 where book.book\_id = book\_id\_;

update member set no\_of\_books = no\_of\_books - 1 where member.mem\_id = mem\_id\_;

SET days = datediff(date\_today, due\_date);

IF(days\&gt;0) THEN

INSERT INTO book\_fine(mem\_id,book\_id,amount) VALUES(mem\_id\_, book\_id\_, days\*5);

RETURN days\*5;

ELSE

RETURN 0;

END IF;

END $$

1. **RETURN PERIODICAL:**

DELIMITER $$

CREATE FUNCTION return\_periodical(perio\_id\_ INT, mem\_id\_ INT) RETURNS FLOAT DETERMINISTIC

BEGIN

DECLARE date\_today, due\_date DATE;

DECLARE days INT;

SET date\_today = current\_date();

SELECT perioTrans.due\_date FROM perioTrans where perioTrans.perio\_id = perio\_id\_ AND perioTrans.mem\_id = mem\_id\_ INTO due\_date;

update perioTrans set return\_date = date\_today where perioTrans.perio\_id = perio\_id\_ AND perioTrans.mem\_id=mem\_id\_;

update periodical set no\_of\_copies = no\_of\_copies + 1 where periodical.perio\_id = perio\_id\_;

update member set no\_of\_books = no\_of\_perios - 1 where member.mem\_id = mem\_id\_;

SET days = datediff(date\_today, due\_date);

IF(days\&gt;0) THEN

INSERT INTO perio\_fine(mem\_id,perio\_id,amount) VALUES(mem\_id\_, perio\_id\_, days\*5);

RETURN days\*5;

ELSE

RETURN 0;

END IF;

END$$

**TRIGGERS**

1. **REMOVE MEMBER:**

DELIMITER $$

CREATE TRIGGER remove\_member before DELETE on member

for each row

BEGIN

DECLARE msg1, msg2, msg3 VARCHAR(100);

IF((SELECT no\_of\_books FROM member WHERE old.mem\_id = mem\_id)!= 0) THEN

SET msg1 = concat(&#39;The member cannot be removed as he/she already posseses &#39;, (SELECT member.no\_of\_books FROM member WHERE old.mem\_id= mem\_id), &#39; books and&#39;, (SELECT member.no\_of\_perios FROM member WHERE old.mem\_id= mem\_id), &#39; periodicals&#39;);

signal sqlstate &#39;45001&#39; SET message\_text = msg1;

END IF;

IF((SELECT count(\*) FROM book\_fine WHERE payment\_date = null and old.mem\_id=mem\_id)!=0) THEN

SET msg2 = concat (&#39;The member cannot be removed as he/she has fines unpaid. Pending transactions = &#39; , (SELECT count(\*) FROM book\_fine WHERE payment\_date = null and old.mem\_id=mem\_id));

signal sqlstate &#39;45001&#39; SET message\_text = msg2;

END IF;

IF((SELECT count(\*) FROM perio\_fine WHERE payment\_date = null and old.mem\_id=mem\_id)!=0) THEN

SET msg3 = concat (&#39;The member cannot be removed as he/she has fines unpaid. Pending transactions = &#39; , (SELECT count(\*) FROM perio\_fine WHERE payment\_date = null and old.mem\_id=mem\_id));

signal sqlstate &#39;45001&#39; SET message\_text = msg3;

END IF;

END $$

1. **REMOVE BOOK:**

DELIMITER $$

CREATE TRIGGER remove\_book before UPDATE on book

for each row

BEGIN

DECLARE msg VARCHAR(100);

IF (new.no\_of\_copies\&lt;0) THEN

SET msg = concat(&#39;Not enough books available to DELETE the quantity mentioned. Number of books available : &#39; , (SELECT old.no\_of\_copies FROM book WHERE old.book\_id = book\_id));

signal sqlstate &#39;45001&#39; SET message\_text = msg;

END IF;

END $$

1. **REMOVE PERIODICAL**

DELIMITER $$

CREATE TRIGGER remove\_periodical before UPDATE on periodical

for each row

BEGIN

DECLARE msg VARCHAR(100);

IF (new.no\_of\_copies\&lt;0) THEN

SET msg = concat(&#39;Not enough periodicals available to DELETE the quantity mentioned. Number of books available : &#39; , (SELECT old.no\_of\_copies FROM periodical WHERE old.perio\_id = perio\_id));

signal sqlstate &#39;45001&#39; SET message\_text = msg;

END IF;

END $$

1. **ADD SUPPLIER**

CREATE TRIGGER tri\_2

BEFORE insert ON supplier

for each row

BEGIN

DECLARE msg VARCHAR(128);

IF new.gst\_no=(SELECT gst\_no FROM supplier WHERE gst\_no = new.gst\_no) THEN

SET msg = &#39;Error: Supplier already exsists&#39;;

signal sqlstate &#39;45002&#39; SET message\_text = msg;

END IF;

END $$

1. **ISSUE BOOK:**

CREATE TRIGGER tri\_1

BEFORE insert ON bookTrans

for each row

BEGIN

DECLARE tep INT;

DECLARE msg VARCHAR(128);

SELECT count(\*) INTO tep FROM book WHERE book\_id = new.book\_id;

IF tep!=1 THEN

SET msg = concat(&#39;Error: The book&#39;, book\_id, &#39; does not exsist in the library&#39;);

signal sqlstate &#39;45003&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_3

BEFORE insert ON bookTrans

for each row

BEGIN

DECLARE mep INT;

DECLARE msg VARCHAR(128);

SELECT count(\*) INTO mep FROM member WHERE mem\_id = new.mem\_id;

IF mep!=1 THEN

SET msg = concat(&#39;Error:The user &#39;, new.mem\_id, &#39; is not a member of club&#39;);

signal sqlstate &#39;45004&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_4

BEFORE insert ON bookTrans

for each row

BEGIN

DECLARE sep INT;

DECLARE msg VARCHAR(128);

SELECT count(\*) INTO sep FROM bookTrans WHERE book\_id = new.book\_id and mem\_id = new.mem\_id and return\_date is null;

IF sep=1 THEN

SET msg = concat(&#39;The user already have this book&#39;);

signal sqlstate &#39;45005&#39; SET message\_text = msg;

END IF;

END$$

CREATE TRIGGER tri\_5

BEFORE insert ON bookTrans

for each row

BEGIN

DECLARE mb INT;

DECLARE typ VARCHAR(3);

DECLARE msg VARCHAR(128);

SELECT no\_of\_books INTO mb FROM member WHERE mem\_id=new.mem\_id;

SET typ := (SELECT mem\_type FROM member WHERE mem\_id=new.mem\_id);

IF typ=&#39;FAC&#39;THEN

IF mb \&gt;= 4 THEN

SET msg = concat(&#39;Your have reached monthly borrow limit of 4 books&#39;);

signal sqlstate &#39;45006&#39; SET message\_text = msg;

END IF;

ELSEIF typ=&#39;STU&#39; THEN

IF mb \&gt;= 2 THEN

SET msg = concat(&#39;Your have reached monthly borrow limit of 2 books&#39;);

signal sqlstate &#39;45008&#39; SET message\_text = msg;

END IF;

END IF;

END $$

CREATE TRIGGER tri\_6

BEFORE insert ON bookTrans

for each row

BEGIN

DECLARE bep INT;

DECLARE msg VARCHAR(128);

SELECT no\_of\_copies INTO bep FROM book WHERE book\_id=new.book\_id;

IF bep\&gt;=1 THEN

SET msg = concat(&#39; The book is not available in the library &#39;);

signal sqlstate &#39;45007&#39; SET message\_text = msg;

END IF;

END $$

1. **ISSUE PERIODICAL:**

CREATE TRIGGER tri\_7

BEFORE insert ON periodicalTrans

for each row

BEGIN

DECLARE tep INT;

DECLARE msg VARCHAR(128);

SELECT count(\*) INTO tep FROM periodical WHERE perio\_id = new.perio\_id;

IF tep!=1 THEN

SET msg = concat(&#39;Error: The book&#39;, perio\_id, &#39; does not exsist in the library&#39;);

signal sqlstate &#39;45009&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_8

BEFORE insert ON periodicalTrans

for each row

BEGIN

DECLARE mep INT;

DECLARE msg VARCHAR(128);

SELECT count(\*) INTO mep FROM member WHERE mem\_id = new.mem\_id;

IF mep!=1 THEN

SET msg = concat(&#39;Error:The user &#39;, new.mem\_id, &#39; is not a member of club&#39;);

signal sqlstate &#39;45010&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_9

BEFORE insert ON peridicalTrans

for each row

BEGIN

DECLARE sep INT;

DECLARE msg VARCHAR(128);

SELECT count(\*) INTO sep FROM periodicalTrans WHERE perio\_id = new.perio\_id and mem\_id = new.mem\_id and return\_date is null;

IF sep=1 THEN

SET msg = concat(&#39;The user already have this periodical&#39;);

signal sqlstate &#39;45011&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_10

BEFORE insert ON periodicalTrans

for each row

BEGIN

DECLARE mb INT;

DECLARE typ VARCHAR(3);

DECLARE msg VARCHAR(128);

SELECT no\_of\_perios INTO mb FROM member WHERE mem\_id=new.mem\_id;

SET typ = (SELECT mem\_type FROM member WHERE mem\_id=new.mem\_id);

IF typ=&#39;FAC&#39; THEN

IF mb \&gt;= 2 THEN

SET msg = concat(&#39;Your have reached monthly borrow limit of 2 periodical&#39;);

signal sqlstate &#39;45012&#39; SET message\_text = msg;

END IF;

ELSEIF typ=&#39;STU&#39; THEN

IF mb \&gt;= 1 THEN

SET msg = concat(&#39;Your have reached monthly borrow limit of 1 periodical&#39;);

signal sqlstate &#39;45013&#39; SET message\_text = msg;

END IF;

END IF;

END $$

CREATE TRIGGER tri\_11

BEFORE insert ON periodicalTrans

for each row

BEGIN

DECLARE bep INT;

DECLARE msg VARCHAR(128);

SELECT no\_of\_copies INTO bep FROM periodical WHERE perio\_id=new.perio\_id;

IF bep\&gt;=1 THEN

SET msg = concat(&#39; The periodical is not available in the library &#39;);

signal sqlstate &#39;45014&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_12

BEFORE insert on book

for each row

BEGIN

DECLARE msg VARCHAR(128);

IF new.no\_of\_copies\&lt;0 THEN

SET msg = &#39; negative value is not allowed &#39;;

signal sqlstate &#39;45015&#39; SET message\_text = msg;

END IF;

END $$

CREATE TRIGGER tri\_13

BEFORE insert on periodical

for each row

BEGIN

DECLARE msg VARCHAR(128);

IF new.no\_of\_copies\&lt;0 THEN

SET msg = &#39; negative value is not allowed &#39;;

signal sqlstate &#39;45015&#39; SET message\_text = msg;

END IF;

END $$

1. **BOOK TRANSACTION:**

CREATE TRIGGER incr\_trigger\_insert

AFTER INSERT ON bookTrans

FOR EACH ROW

BEGIN

UPDATE book SET no\_of\_copies = no\_of\_copies-1 WHERE book\_id = NEW.book\_id;

UPDATE MEMBER SET no\_of\_books = no\_of\_books+1 WHERE mem\_id = NEW.mem\_id;

END $$

CREATE TRIGGER incr\_trigger\_UPDATE

AFTER UPDATE ON bookTrans

FOR EACH ROW

BEGIN

UPDATE book SET no\_of\_copies = no\_of\_copies+1 WHERE book\_id = old.book\_id;

UPDATE MEMBER SET no\_of\_books = no\_of\_books-1 WHERE mem\_id = NEW.mem\_id;

END $$

1. **PERIODICAL TRANSACTION:**

CREATE TRIGGER incr\_trigger\_insert\_1

AFTER INSERT ON periodicalTrans

FOR EACH ROW

BEGIN

UPDATE periodical SET no\_of\_copies = no\_of\_copies-1 WHERE perio\_id = NEW.perio\_id;

UPDATE MEMBER SET no\_of\_perios = no\_of\_perios+1 WHERE mem\_id = NEW.mem\_id;

END $$

CREATE TRIGGER incr\_trigger\_UPDATE\_1

AFTER UPDATE ON periodicalTrans

FOR EACH ROW

BEGIN

UPDATE periodical SET no\_of\_copies = no\_of\_copies+1 WHERE perio\_id = old.perio\_id;

UPDATE MEMBER SET no\_of\_perios = no\_of\_perios-1 WHERE mem\_id = NEW.mem\_id;

END $$

1. **TRANSFER BOOK TRANSACTION TO HISTORY:**

CREATE TRIGGER move\_trigger

before DELETE on bookTrans

for each row

BEGIN

INSERT INTO bookTransaction\_history VALUES(old.book\_id, old.mem\_id,old.issue\_date,old.due\_date,old.return\_date);

END $$

1. **TRANSFER PERIODICAL TRANSACTION TO HISTORY:**

CREATE TRIGGER move\_trigger\_1

before DELETE on periodicalTrans

for each row

BEGIN

INSERT INTO periodicalTransaction\_history VALUES(old.perio\_id, old.mem\_id,old.issue\_date,old.due\_date,old.return\_date);

END $$

**SCREENSHOTS OF PROCEDURE CALL**

1. **Login: (GUI Based Only)**

![](RackMultipart20210217-4-1y7nb0x_html_99c319071554e326.png)

1. **Add Book: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_b7c2bc877d8b1daa.png)

1. **Add Supplier:**

![](RackMultipart20210217-4-1y7nb0x_html_a378f3a7f1c7dac.png)

1. **Add member:**

![](RackMultipart20210217-4-1y7nb0x_html_ff3596c5d3f4605a.png)

1. **Add Periodical:**

![](RackMultipart20210217-4-1y7nb0x_html_26654fae9d284ad6.png)

1. **Remove Book: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_db5cae9551d01497.png)

1. **Remove Periodical:**

![](RackMultipart20210217-4-1y7nb0x_html_261c6eb59add07cc.png)

1. **Issue Book: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_f67f38be3c718a9c.png)

1. **Issue Periodical:**

![](RackMultipart20210217-4-1y7nb0x_html_75d9f5a5050397c4.png)

1. **Return Book: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_6f5de868b0604651.png)

1. **Fine Calculation: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_b109c7472fcd5118.png)

![](RackMultipart20210217-4-1y7nb0x_html_b4953c0ae9c88c73.png)

1. **Search Member:**

![](RackMultipart20210217-4-1y7nb0x_html_f5421a3282a55032.png)

1. **Search Book: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_e68a810f0ecfdd55.png)

1. **Supplier View:**

![](RackMultipart20210217-4-1y7nb0x_html_3304df589dd79280.png)

1. **Book View: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_5411f424c3f2d9f6.png)

1. **Search Book: (Same for Periodical)**

![](RackMultipart20210217-4-1y7nb0x_html_e68a810f0ecfdd55.png)

1. **Search Member:**

![](RackMultipart20210217-4-1y7nb0x_html_f5421a3282a55032.png)

**SCREENSHOTS OF TRIGGER VIOLATION**

1. **Supplier Trigger:**

![](RackMultipart20210217-4-1y7nb0x_html_d1d0df2ccd4a9231.png)

1. **Remove Trigger:**

![](RackMultipart20210217-4-1y7nb0x_html_bdd7fbfe1059c1fc.png)

1. **Issue Trigger:**

![](RackMultipart20210217-4-1y7nb0x_html_4a42acddfd4dd211.png)

1. **Return Trigger:**

![](RackMultipart20210217-4-1y7nb0x_html_ef46c43d2f3153d9.png)

**SQL BASED SCREENSHOTS**

**1. Add Book:**

![](RackMultipart20210217-4-1y7nb0x_html_21145effd0b221f2.png)

**2. Add Member:**

![](RackMultipart20210217-4-1y7nb0x_html_4c741305477360f4.png)

**3. Add Periodical:**

![](RackMultipart20210217-4-1y7nb0x_html_590d3de660e0118c.png)

1. **Add Newspaper:**

![](RackMultipart20210217-4-1y7nb0x_html_c10d11c2478e9600.png)

1. **Add Supplier:**

![](RackMultipart20210217-4-1y7nb0x_html_56e3d78bd9319d62.png)

1. **Issue Book:**

![](RackMultipart20210217-4-1y7nb0x_html_161c2cf30cf699f0.png)

1. **Issue Trigger:**

![](RackMultipart20210217-4-1y7nb0x_html_a7038b5c21dfb42f.png)

1. **Return Book:**

![](RackMultipart20210217-4-1y7nb0x_html_b071910920723dd3.png)

1. **BookTransaction:**

![](RackMultipart20210217-4-1y7nb0x_html_e74bc23c392c2e0e.png)

![](RackMultipart20210217-4-1y7nb0x_html_67109a74d16bec60.png)

1. **Return Error:**

![](RackMultipart20210217-4-1y7nb0x_html_5755e8090064f05e.png)

1. **Fine table:**

![](RackMultipart20210217-4-1y7nb0x_html_baecd344b0bdb753.png)

1. **Make Payment:**

![](RackMultipart20210217-4-1y7nb0x_html_505c0ae97cc04e45.png)

1. **Book Transaction History Trigger:**

![](RackMultipart20210217-4-1y7nb0x_html_412f38dcb1688791.png)

1. **Fetch Periodical:**

![](RackMultipart20210217-4-1y7nb0x_html_71282645c7d1c575.png)
