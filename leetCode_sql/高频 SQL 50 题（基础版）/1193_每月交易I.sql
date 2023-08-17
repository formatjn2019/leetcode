SELECT Date_Format(trans_date, '%Y-%m')       month
     , country
     , COUNT(*)                               trans_count
     , SUM(state = 'approved')                approved_count
     , SUM(amount)                            trans_total_amount
     , SUM(if(state = 'approved', amount, 0)) approved_total_amount

FROM Transactions
GROUP BY month, country