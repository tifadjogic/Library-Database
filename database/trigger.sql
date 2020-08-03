create or replace NONEDITIONABLE TRIGGER copy_trigger
AFTER UPDATE OR DELETE ON COPY_TABLE
FOR EACH ROW
DECLARE
b_id NUMBER;
BEGIN
IF DELETING THEN
SELECT B.isbn INTO b_id FROM BOOKS_TABLE B, TABLE (B.c_list)C WHERE C.copy_id=:OLD.copy_id;
DELETE FROM TABLE(SELECT c_list FROM BOOKS_TABLE b WHERE b.isbn=b_id) c WHERE :OLD.copy_id=c.copy_id;
ELSIF UPDATING THEN
SELECT B.isbn INTO b_id FROM BOOKS_TABLE B, TABLE (B.c_list)C WHERE C.copy_id=:NEW.copy_id;
UPDATE TABLE (SELECT c_list FROM BOOKS_TABLE B WHERE b.isbn=b_id)c SET c.user_ref=:NEW.user_ref WHERE c.copy_id=:NEW.copy_id;
END IF;
END;
/