SELECT DISTINCT s.student_id, student_name
FROM Exam e
         LEFT JOIN Student s
                   on e.student_id = s.student_id
WHERE e.student_id not in (SELECT DISTINCT student_id
                           FROM (SELECT *,
                                        RANK() OVER (PARTITION BY exam_id ORDER BY score)      od1,
                                        RANK() OVER (PARTITION BY exam_id ORDER BY score DESC) od2
                                 FROM Exam) t
                           WHERE od1 = 1
                              OR od2 = 1)
ORDER BY student_id;
