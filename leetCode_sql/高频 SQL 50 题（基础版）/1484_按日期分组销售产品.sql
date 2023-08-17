SELECT c.category, IFNULL(accounts_count,0) accounts_count
FROM (SELECT 'Low Salary' category
      UNION
      SELECT 'High Salary' category
      UNION
      SELECT 'Average Salary' category) c
         LEFT JOIN

     (SELECT CASE
                 WHEN INCOME < 20000
                     THEN 'Low Salary'
                 WHEN INCOME > 50000
                     THEN 'High Salary'
                 ELSE 'Average Salary'
                 END AS category,
             count(*)   accounts_count
      FROM Accounts
      GROUP BY category) a
     on a.category = c.category
