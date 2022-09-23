package problems

type Cashier struct {
	count    int
	sep      int
	discount int
	prices   map[int]int
}

func CasierConstructor(n int, discount int, products []int, prices []int) Cashier {
	priceMap := map[int]int{}
	for i := 0; i < len(products); i++ {
		priceMap[products[i]] = prices[i]
	}
	return Cashier{count: 0, sep: n, discount: discount, prices: priceMap}
}

func (this *Cashier) GetBill(product []int, amount []int) float64 {
	this.count++
	sum := 0
	for i := 0; i < len(product); i++ {
		sum += this.prices[product[i]] * amount[i]
	}
	result := float64(sum)
	if this.count%this.sep == 0 {
		result = result - (float64(this.discount)*result)/100
	}
	return result
}
