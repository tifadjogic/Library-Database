INSERT INTO author_table
VALUES(author_type(authors_seq.NEXTVAL,'Gabriel','G. Márquez',to_date('6-MAR-1927','dd-mon-rrrr'),'17-APR-14'));

INSERT INTO author_table
VALUES(author_type(authors_seq.NEXTVAL,'Charles','Bukowski',to_date('16-AUG-1920','dd-mon-rrrr'),'9-MAR-94'));

INSERT INTO author_table
VALUES(author_type(authors_seq.NEXTVAL,'Francis','S. Fitzgerald',to_date('24-SEP-1896','dd-mon-rrrr'),to_date('21-DEC-1940','dd-mon-rrrr')));

INSERT INTO author_table
VALUES(author_type(authors_seq.NEXTVAL,'Joanne','K. Rowling','31-JUL-1965',NULL));

INSERT INTO member_table
VALUES(librarian_type(member_seq.NEXTVAL,'Adna','Alic','adna.alic10@gmail.com','adna','librarian','01-JAN-02',800));

INSERT INTO member_table
VALUES(librarian_type(member_seq.NEXTVAL,'Tifa','Dogic','tifadjogic@gmail.com','tifa','librarian','01-JAN-02',800));


INSERT INTO member_table
VALUES(user_type(member_seq.NEXTVAL,'Lejla','Mujakic','lela.mk@gmail.com','lela','user','0611545321',address_type(10,'Luka','Konjic',88400,'BiH'),'01-JAN-20','31-JAN-20',null,loans_table_type()));

INSERT INTO member_table
VALUES(user_type(member_seq.NEXTVAL,'Tarik','Muharem','tm@gmail.com','tare','user','0621545321',address_type(1,'Titova','Sarajevo',71000,'BiH'),'01-JAN-20','31-DEC-20',null,loans_table_type()));


INSERT INTO books_table
VALUES(book_type(978316148410,'One Hundred Years of Solitude','Magic realism',to_date('10-MAY-1967','dd-mon-rrrr'),(SELECT REF (A) FROM author_table A WHERE A.surname='G. Márquez'),CopyList()));

INSERT INTO books_table
VALUES(book_type(1566199093,'Post Office','Autobiographical novel',to_date('01-APR-1971','dd-mon-rrrr'),(SELECT REF (A) FROM author_table A WHERE A.surname='Bukowski'),CopyList()));

INSERT INTO books_table
VALUES(book_type(9781433210471,'The Great Gatsby','Historical fiction',to_date('10-APR-1925','dd-mon-rrrr'),(SELECT REF (A) FROM author_table A WHERE A.surname='S. Fitzgerald'),CopyList()));

INSERT INTO books_table
VALUES(book_type(9780739360385,'Harry Potter and the Deathly Hallows','Magical Realism','21-JUL-2007',(SELECT REF (A) FROM author_table A WHERE A.surname='K. Rowling'),CopyList()));

INSERT INTO books_table
VALUES(book_type(9780307283641,'Harry Potter and the Half-Blood Prince','Magical Realism','21-JUL-2005',(SELECT REF (A) FROM author_table A WHERE A.surname='K. Rowling'),CopyList()));

INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=978316148410) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);
INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=978316148410) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);
INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=978316148410) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);

INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=1566199093) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);
INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=1566199093) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);

INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=9781433210471) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);
INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=9781433210471) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);

INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=9780739360385) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);
INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=9780739360385) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);

INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=9780307283641) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);
INSERT INTO COPY_TABLE VALUES (copy_seq.NEXTVAL, NULL);
INSERT INTO TABLE (SELECT c_list FROM BOOKS_TABLE WHERE isbn=9780307283641) SELECT * FROM COPY_TABLE c WHERE c.copy_id=(SELECT MAX(copy_id) FROM COPY_TABLE);