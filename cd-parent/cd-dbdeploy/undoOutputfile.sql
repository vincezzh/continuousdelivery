
-- START UNDO OF CHANGE SCRIPT #4: 004_update_another_password.sql

START TRANSACTION;


UPDATE zuser SET `password`='abcd' WHERE `username`='sukie';



DELETE FROM changelog WHERE change_number = 4;

COMMIT;

-- END UNDO OF CHANGE SCRIPT #4: 004_update_another_password.sql

