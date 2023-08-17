SELECT ast.machine_id, round(AVG((aed.timestamp - ast.timestamp)), 3) processing_time
FROM Activity ast
         INNER JOIN Activity aed
                    ON ast.machine_id = aed.machine_id
                        AND ast.process_id = aed.process_id
                        AND ast.activity_type = 'start'
                        AND aed.activity_type = 'end'
GROUP BY ast.machine_id;


### 题解

SELECT machine_id,
       round(AVG(IF(activity_type = 'start', -timestamp, timestamp) * 2), 3) processing_time
FROM Activity
GROUP BY machine_id;