# 连接
SELECT start_id, MIN(end_id) end_id
FROM (SELECT log_id start_id
      FROM Logs
      WHERE (log_id - 1) NOT IN (SELECT * FROM Logs)) s
         LEFT JOIN
     (SELECT log_id end_id
      FROM Logs
      WHERE (log_id + 1) NOT IN (SELECT * FROM Logs)) e
     ON start_id <= end_id
GROUP BY start_id;


# 窗口函数
SELECT MIN(log_id) start_id, MAX(log_id) end_id
FROM (SELECT log_id, log_id - (ROW_NUMBER() OVER (ORDER BY log_id)) diff
      FROM Logs) t
GROUP BY diff