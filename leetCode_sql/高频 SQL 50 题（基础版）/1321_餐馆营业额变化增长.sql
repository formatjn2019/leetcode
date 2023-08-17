SELECT c1.visited_on, sum(c2.amount) amount, ROUND(sum(c2.amount) / 7, 2) average_amount
FROM (SELECT DISTINCT visited_on FROM Customer) c1
         LEFT JOIN Customer c2
                   on DATEDIFF(c1.visited_on, c2.visited_on) >= 0 AND DATEDIFF(c1.visited_on, c2.visited_on) < 7
GROUP BY c1.visited_on
HAVING ADDDATE(c1.visited_on, -6) >= (SELECT MIN(visited_on) FROM Customer)
ORDER BY c1.visited_on