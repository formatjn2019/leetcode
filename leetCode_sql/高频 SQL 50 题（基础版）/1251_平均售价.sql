SELECT Prices.product_id, round(sum(price * units) / sum(units), 2) average_price

FROM Prices
         LEFT JOIN UnitsSold
                   ON Prices.product_id = UnitsSold.product_id
                       AND DateDiff(start_date, purchase_date) <= 0
                       AND DateDiff(end_date, purchase_date) >= 0
GROUP BY Prices.product_id