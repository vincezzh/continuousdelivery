-- dbdeploy will wrap the application of each change script
-- in a transaction
--
-- DML statements (INSERT, UPDATE etc) can be applied transactionally,
-- so therefore dbdeploy will ensure that either the whole of this script applies
-- or none of it does.
--
UPDATE zuser SET `password`='abcd' WHERE `username`='vince';

--//@UNDO

UPDATE zuser SET `password`='1234' WHERE `username`='vince';

