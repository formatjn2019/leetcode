package problems

func MergeStones(stones []int, k int) int {
	return mergeStones(stones, k)
}
func mergeStones(stones []int, k int) int {
	if (len(stones)-k)%(k-1) != 0 {
		return -1
	}
	result := 0
	//滑动窗口
	for len(stones) > 1 {
		start, sum := 0, 0
		for i := 0; i < k; i++ {
			sum += stones[i]
		}
		minSum := sum
		for i := k; i < len(stones); i++ {
			sum += stones[i] - stones[i-k]
			if sum < minSum {
				start = i - k + 1
				minSum = sum
			}
		}
		result += minSum
		stones[start+k-1] = minSum
		stones = append(stones[:start], stones[start+k-1:]...)
	}
	return result
}
