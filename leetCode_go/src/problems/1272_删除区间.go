package problems

func removeInterval(intervals [][]int, toBeRemoved []int) [][]int {
	minRemove, maxRemove := toBeRemoved[0], toBeRemoved[1]
	var result [][]int
	for _, interval := range intervals {
		// 拆分
		if interval[0] < minRemove && interval[1] > maxRemove {
			result = append(result, []int{interval[0], minRemove})
			result = append(result, []int{maxRemove, interval[1]})
		} else {
			if interval[0] >= minRemove && interval[0] <= maxRemove {
				interval[0] = maxRemove
			}
			if interval[1] >= minRemove && interval[1] <= maxRemove {
				interval[1] = minRemove
			}
			if interval[0] < interval[1] {
				result = append(result, interval)
			}
		}
	}
	return result
}
