package problems

func maxDistance(arrays [][]int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	result, preMin, preMax := -1, 0, 0
	for _, arr := range arrays {
		if len(arr) > 0 {
			curMin, curMax := arr[0], arr[len(arr)-1]
			if result == -1 {
				preMin, preMax = curMin, curMax
				result = 0
			} else {
				result = max(result, max(curMax-preMin, preMax-curMin))
				preMin, preMax = min(preMin, curMin), max(preMax, curMax)
			}
		}
	}
	return result
}
