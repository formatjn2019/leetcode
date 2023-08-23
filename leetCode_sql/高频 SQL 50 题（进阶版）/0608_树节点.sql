SELECT DISTINCT t1.id,
                CASE
                    WHEN t1.p_id IS NULL
                        THEN 'Root'
                    WHEN t3.p_id is NULL
                        THEN 'Leaf'
                    ELSE 'Inner'
                    END type
FROM Tree t1
         LEFT JOIN TREE t2
                   ON t1.p_id = t2.id
         LEFT JOIN TREE t3
                   ON t3.p_id = t1.id