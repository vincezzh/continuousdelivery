-- dbdeploy will wrap the application of each change script
-- in a transaction
--
-- DML statements (INSERT, UPDATE etc) can be applied transactionally,
-- so therefore dbdeploy will ensure that either the whole of this script applies
-- or none of it does.
--
INSERT INTO zuser VALUES ('vince', '1234', 10001);

--//@UNDO

DELETE FROM zuser WHERE username = 'vince';

