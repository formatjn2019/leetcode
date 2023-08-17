SELECT customer_id
FROM Customer
         inner join Product
                    ON Customer.product_key = Product.product_key
GROUP BY customer_id
HAVING count(DISTINCT Customer.product_key) = (SELECT COUNT(*) FROM Product)