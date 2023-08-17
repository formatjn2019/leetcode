SELECT po.product_id, if(new_price is null, 10, new_price) price
FROM (SELECT distinct product_id
      FROM Products) po
         left join

     (SELECT p.product_id, new_price
      from Products p
               RIGHT JOIN
           (SELECT product_id, max(change_date) change_date
            FROM Products
            WHERE change_date <= '2019-08-16'
            GROUP BY product_id) t
           on p.product_id = t.product_id and p.change_date = t.change_date) pd
     on po.product_id = pd.product_id