
-- START CHANGE SCRIPT #4: 004_update_another_password.sql

-- dbdeploy will wrap the application of each change script
-- in a transaction
--
-- DML statements (INSERT, UPDATE etc) can be applied transactionally,
-- so therefore dbdeploy will ensure that either the whole of this script applies
-- or none of it does.
--
UPDATE zuser SET `password`='zzzz' WHERE `username`='sukie';



INSERT INTO changelog (change_number, complete_dt, applied_by, description)
 VALUES (4, CURRENT_TIMESTAMP, USER(), '004_update_another_password.sql');

COMMIT;

-- END CHANGE SCRIPT #4: 004_update_another_password.sql

