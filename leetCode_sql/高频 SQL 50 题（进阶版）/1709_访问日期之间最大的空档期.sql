SELECT user_id, MAX(wd) biggest_window
FROM (SELECT user_id,
             DATEDIFF((LEAD(visit_date, 1, '2021-1-1') OVER (PARTITION BY user_id ORDER BY visit_date )),
                      visit_date) wd
      FROM UserVisits) t
GROUP BY user_id