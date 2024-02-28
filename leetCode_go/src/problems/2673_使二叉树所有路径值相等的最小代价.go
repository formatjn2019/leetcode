package problems

func minIncrements(n int, cost []int) int {
	var result int
	var getSum func(idx int) int
	getSum = func(idx int) int {
		if idx >= len(cost) {
			return 0
		}
		// lChild
		lSum := getSum(idx*2 + 1)
		// rChild
		rSum := getSum((idx + 1) * 2)
		// 假定l大
		if lSum < rSum {
			lSum, rSum = rSum, lSum
		}

		result += lSum - rSum
		return lSum + cost[idx]
	}
	getSum(0)
	return result
}
