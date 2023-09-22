package problems

func DistMoney(money int, children int) int {
	return distMoney(money, children)
}
func distMoney(money int, children int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	//每人至少分一块
	money -= children
	if money < 0 {
		return -1
	}
	//贪心 尝试分8块钱
	result := min(children, money/7)
	//剩余钱数
	money -= result * 7
	//有剩余
	if result != 0 && (money == 3 && result == children-1 || result == children && money > 0) {
		return result - 1
	}
	return result
}
