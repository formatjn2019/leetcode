SELECT NAME, SUM(amount) BALANCE
FROM Users
         LEFT JOIN Transactions
                   ON Users.account = Transactions.account
GROUP BY Users.account
HAVING BALANCE > 10000