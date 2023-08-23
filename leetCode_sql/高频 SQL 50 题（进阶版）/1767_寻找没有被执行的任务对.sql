# Create table If Not Exists Tasks (task_id int, subtasks_count int);
# Create table If Not Exists Executed (task_id int, subtask_id int);
# # Truncate table Tasks
# insert into Tasks (task_id, subtasks_count) values ('1', '3');
# insert into Tasks (task_id, subtasks_count) values ('2', '2');
# insert into Tasks (task_id, subtasks_count) values ('3', '4');
# # Truncate table Executed
# insert into Executed (task_id, subtask_id) values ('1', '2');
# insert into Executed (task_id, subtask_id) values ('3', '1');
# insert into Executed (task_id, subtask_id) values ('3', '2');
# insert into Executed (task_id, subtask_id) values ('3', '3');
# insert into Executed (task_id, subtask_id) values ('3', '4');

WITH RECURSIVE subtask (task_id, subtask_id)
                   as (select task_id, subtasks_count as subtask_id
                       FROM Tasks
                       UNION ALL
                       select task_id, subtask_id - 1
                       FROM subtask
                       WHERE subtask_id > 1)


SELECT *
FROM subtask
WHERE (task_id, subtask_id) NOT IN (SELECT * FROM Executed)