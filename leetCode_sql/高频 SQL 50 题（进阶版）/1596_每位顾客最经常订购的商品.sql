SELECT DISTINCT customer_id, t.product_id, product_name
FROM (SELECT *, RANK() OVER (PARTITION BY customer_id ORDER BY COUNT(product_id) DESC) rk
      FROM Orders
      group by customer_id, product_id) t
         LEFT JOIN Products
                   ON t.product_id = Products.product_id
WHERE rk = 1;