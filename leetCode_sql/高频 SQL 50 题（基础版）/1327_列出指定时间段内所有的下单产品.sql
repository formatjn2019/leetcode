SELECT product_name, SUM(unit) unit
FROM Orders
         LEFT JOIN Products
                   ON Orders.product_id = Products.product_id
WHERE order_date > '2020-01-31'
  AND order_date < '2020-03-01'
GROUP BY Orders.product_id
HAVING unit >= 100