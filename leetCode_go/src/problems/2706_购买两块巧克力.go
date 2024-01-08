package problems

func buyChoco(prices []int, money int) int {
	m1p, m2p := 0, 1
	if prices[1] < prices[0] {
		m1p, m2p = m2p, m1p
	}
	for i := 2; i < len(prices); i++ {
		if price := prices[i]; price < prices[m1p] {
			m1p, m2p = i, m1p
		} else if price < prices[m2p] {
			m2p = i
		}
	}
	if prices[m1p]+prices[m2p] > money {
		return money
	} else {
		return money - prices[m1p] - prices[m2p]
	}
}
