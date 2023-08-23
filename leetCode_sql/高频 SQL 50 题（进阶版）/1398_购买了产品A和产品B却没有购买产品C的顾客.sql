SELECT DISTINCT o1.customer_id, customer_name
FROM Orders o1
         INNER JOIN Orders o2
                    ON o1.customer_id = o2.customer_id
                        AND o1.product_name = 'A' AND o2.product_name = 'B'
         LEFT JOIN Orders o3
                   ON o1.customer_id = o3.customer_id AND o3.product_name = 'C'
         LEFT JOIN Customers
                   ON Customers.customer_id = o1.customer_id
WHERE o3.product_name IS NULL
ORDER BY o3.customer_id