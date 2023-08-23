SELECT transaction_id
FROM (SELECT *, RANK() OVER (PARTITION BY Date_Format(day, '%Y%m%d') ORDER BY amount DESC) rk
      FROM Transactions) t
WHERE rk = 1
ORDER BY transaction_id