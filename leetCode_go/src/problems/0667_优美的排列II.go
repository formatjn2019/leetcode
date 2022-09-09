package problems

func ConstructArray(n int, k int) []int {
	return constructArray(n, k)
}

func constructArray(n int, k int) []int {
	// 1 2 3 4 5
	// 1 5 4 3 2
	// 1 5 2 3 4
	// 1 5 2 4 3
	result := make([]int, n)
	min, max, dir := 1, n, true
	for i := 0; i < n; i++ {
		//方向判断
		if dir {
			result[i] = min
			min++
		} else {
			result[i] = max
			max--
		}
		if k > 1 {
			dir = !dir
			k--
		}
	}
	return result
}
