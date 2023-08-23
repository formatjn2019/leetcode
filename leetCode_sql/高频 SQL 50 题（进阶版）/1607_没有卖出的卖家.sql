SELECT seller_name SELLER_NAME
FROM Seller
         LEFT JOIN Orders
                   ON Seller.seller_id = Orders.seller_id

WHERE YEAR(sale_date) <> 2020
ORDER BY seller_name