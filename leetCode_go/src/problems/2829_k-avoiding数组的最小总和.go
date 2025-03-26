package problems

var MinimumSum = minimumSum

func minimumSum(n int, k int) int {
	var result int
	items := make(map[int]bool)
	for start := 1; len(items) < n; start++ {
		if !items[k-start] {
			items[start] = true
		}
	}
	for num, _ := range items {
		result += num
	}

	return result
}
