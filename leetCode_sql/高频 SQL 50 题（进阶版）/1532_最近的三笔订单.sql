SELECT name customer_name, c.customer_id, order_id, order_date
FROM Customers c
         LEFT JOIN (SELECT customer_id,
                           order_id,
                           order_date,
                           row_number() OVER (PARTITION BY customer_id ORDER BY order_date DESC) rw
                    FROM Orders) t
                   ON c.customer_id = t.customer_id
WHERE rw < 4
ORDER BY customer_name, customer_id, order_date DESC