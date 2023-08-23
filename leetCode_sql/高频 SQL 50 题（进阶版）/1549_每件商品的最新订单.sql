SELECT product_name, t.product_id, order_id, order_date
FROM Products
         RIGHT JOIN (SELECT product_id,
                            order_id,
                            order_date,
                            RANK() OVER (PARTITION BY product_id ORDER BY order_date DESC) rk
                     FROM Orders) t
                    ON Products.product_id = t.product_id
WHERE t.rk = 1
ORDER BY product_name, product_id, order_id