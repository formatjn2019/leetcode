SELECT *
FROM (SELECT 'succeeded' as period_state, MIN(dt) start_date, MAX(dt) end_date
      FROM (SELECT success_date                                        dt,
                   CAST(DATEDIFF(success_date, '2019-01-01') AS SIGNED) -
                   CAST(RANK() OVER (ORDER BY success_date) AS SIGNED) diff
            FROM Succeeded
            WHERE YEAR(success_date) = 2019) t
      GROUP BY diff
      UNION
      SELECT 'failed' as period_state, MIN(dt) start_date, MAX(dt) end_date
      FROM (SELECT fail_date                                        dt,
                   CAST(DATEDIFF(fail_date, '2019-01-01') AS SIGNED) -
                   CAST(RANK() OVER (ORDER BY fail_date) AS SIGNED) diff
            FROM Failed
            WHERE YEAR(fail_date) = 2019) t
      GROUP BY diff) t
ORDER BY start_date