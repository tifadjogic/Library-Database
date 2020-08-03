create or replace NONEDITIONABLE TYPE Address_type AS OBJECT(
building_number NUMBER,
street VARCHAR2(30),
city VARCHAR2 (30),
postcode NUMBER,
country VARCHAR2 (40)
);

/

create or replace NONEDITIONABLE TYPE author_type AS OBJECT (
  author_id NUMBER,
  name VARCHAR2(15),
  surname VARCHAR2(15),
  birth_date DATE,
  death_date DATE
);

/

create or replace NONEDITIONABLE TYPE member_type AS OBJECT (
 member_id NUMBER,
 firstname VARCHAR2(20),
 surname VARCHAR2(30),
 email VARCHAR2(320),
 user_password VARCHAR2(30),
 role VARCHAR2(30),
 MEMBER FUNCTION showInfo RETURN VARCHAR2
 )NOT FINAL;

/

create or replace NONEDITIONABLE TYPE librarian_type UNDER member_type(
hire_date DATE,
salary NUMBER,
OVERRIDING MEMBER FUNCTION showInfo RETURN VARCHAR2
);

/

create or replace NONEDITIONABLE TYPE user_type UNDER member_type(
phone_number VARCHAR2(15),
address address_type,
membership_start_date DATE,
membership_end_date DATE,
copy_ref REF copy_type,
loans_list loans_table_type,
OVERRIDING MEMBER FUNCTION showInfo RETURN VARCHAR2,
MEMBER FUNCTION showBook RETURN VARCHAR2
);

/

create or replace NONEDITIONABLE TYPE copy_type AS OBJECT (
  copy_id NUMBER,
  user_ref REF user_type,
  MEMBER FUNCTION isBorrowed RETURN VARCHAR2
);

/

create or replace NONEDITIONABLE TYPE CopyList
AS TABLE OF copy_type;

/

create or replace NONEDITIONABLE TYPE book_type AS OBJECT (
  isbn NUMBER,
  title VARCHAR2(100),
  genre VARCHAR2(50),
  publication_date DATE,
  author REF Author_type,
  c_list CopyList
);

/

create or replace NONEDITIONABLE TYPE loans_type AS OBJECT (
  loan_id NUMBER,
  date_issued DATE,
  due_for_return DATE,
  return_date DATE,
  copy_ref REF copy_type
);

/

create or replace NONEDITIONABLE TYPE loans_table_type
AS TABLE OF REF loans_type;

/

create or replace NONEDITIONABLE TYPE BODY member_type AS
 MEMBER FUNCTION showInfo RETURN VARCHAR2 IS
  BEGIN
 RETURN ( 'First name: ' || firstname ||  chr(10)||'Last name: ' || surname|| chr(10) || 'E-mail: '|| email);
  END;
END;

/

create or replace NONEDITIONABLE TYPE BODY librarian_type AS 
  OVERRIDING MEMBER FUNCTION showInfo RETURN VARCHAR2 IS
  str VARCHAR2(300);
  BEGIN
str:= (self AS member_type).showInfo || chr(10)|| 'Hire Date:  '||hire_date|| chr(10)|| 'Salary: '|| salary;
  RETURN str;
  END;
  END;

/

create or replace NONEDITIONABLE TYPE BODY user_type AS 
  OVERRIDING MEMBER FUNCTION showInfo RETURN VARCHAR2 IS
  str VARCHAR2(700);
  BEGIN
str:= (self AS member_type).showInfo || chr(10)|| 'Phone number: '||phone_number|| chr(10)|| 'Address: '|| address.street ||' '|| address.building_number||', '||
 address.city||', '||address.country||' '||address.postcode;
  RETURN str;
  END;
 MEMBER FUNCTION showBook RETURN VARCHAR2 IS
 u_copy copy_type;
b_title VARCHAR2(100);
   BEGIN
     SELECT DEREF (copy_ref) INTO u_copy FROM DUAL;
    IF u_copy IS NOT NULL THEN
    BEGIN
    SELECT B.title INTO b_title FROM BOOKS_TABLE B, TABLE (B.c_list)C WHERE C.copy_id=u_copy.copy_id;
    RETURN ('Borrowed' ||b_title);
    EXCEPTION
    WHEN NO_DATA_FOUND THEN
    raise_application_error  (-20004, 'Error: Book title ' ||
    ' does not exist'); 
    END;
    ELSE
    RETURN ('No copy borrowed');
    END IF;
    END;
    end;

/

create or replace NONEDITIONABLE TYPE BODY copy_type AS
  MEMBER FUNCTION isBorrowed RETURN VARCHAR2 IS
   user user_type;
   BEGIN
     select deref(TREAT( user_ref AS REF user_type)) into user from dual;
     IF user IS NULL THEN
     RETURN('Not borrowed');
     ELSE
     RETURN('Borrowed');
     END IF;
  END;
END;

/

