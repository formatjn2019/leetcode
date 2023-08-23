# 单纯分组连接
SELECT Customers.customer_id, name
FROM Product
         LEFT JOIN Orders
                   ON Product.product_id = Orders.product_id
         LEFT JOIN Customers
                   ON Orders.customer_id = Customers.customer_id
WHERE Orders.order_date >= '2020-07-01'
  and Orders.order_date <= '2020-07-31'
  AND Customers.customer_id IN (SELECT customer_id
                                FROM Product
                                         LEFT JOIN Orders
                                                   ON Product.product_id = Orders.product_id
                                WHERE Orders.order_date >= '2020-06-01'
                                  and Orders.order_date <= '2020-06-30'
                                GROUP BY customer_id
                                HAVING SUM(quantity * price) >= 100)
GROUP BY Customers.customer_id
HAVING SUM(quantity * price) >= 100;


# 条件sum
SELECT Customers.customer_id, name
FROM Product
         LEFT JOIN Orders
                   ON Product.product_id = Orders.product_id
         LEFT JOIN Customers
                   ON Orders.customer_id = Customers.customer_id

GROUP BY Customers.customer_id
HAVING SUM(IF(order_date >= '2020-06-01' and order_date <= '2020-06-30', quantity * price, 0)) >= 100
   AND SUM(IF(order_date >= '2020-07-01' and order_date <= '2020-07-31', quantity * price, 0)) >= 100;