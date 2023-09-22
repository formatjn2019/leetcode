package problems

func minCount(coins []int) int {
	var result int
	for _, coin := range coins {
		result += (coin + 1) / 2
	}
	return result
}
