SELECT DISTINCT Product.product_id, product_name
FROM Sales
         LEFT JOIN Product
                   ON Sales.product_id = Product.product_id
WHERE DATEDIFF(sale_date, '2019-01-01') >= 0
  AND DATEDIFF(sale_date, '2019-03-31') <= 0
  AND Product.product_id NOT IN (SELECT product_id
                                 FROM Sales
                                 WHERE DATEDIFF(sale_date, '2019-01-01') < 0
                                    OR DATEDIFF(sale_date, '2019-03-31') > 0)