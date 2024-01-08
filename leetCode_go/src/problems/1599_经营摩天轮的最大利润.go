package problems

func minOperationsMaxProfit(customers []int, boardingCost int, runningCost int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	sum, maxSum, result := 0, 0, -1

	for remain, i := 0, 0; remain > 0 || i < len(customers); i++ {
		if i < len(customers) {
			remain += customers[i]
		}
		users := min(4, remain)
		sum += users*boardingCost - runningCost
		if sum > maxSum {
			result = i + 1
			maxSum = sum
		}
		remain -= users
	}
	return result
}
