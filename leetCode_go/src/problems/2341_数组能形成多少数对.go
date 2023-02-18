package problems

func NumberOfPairs(nums []int) []int {
	return numberOfPairs(nums)
}
func numberOfPairs(nums []int) []int {
	numCountMap := map[int]int{}
	for _, num := range nums {
		numCountMap[num] += 1
	}
	result := make([]int, 2)
	for _, count := range numCountMap {
		result[0] += count / 2
		result[1] += count % 2
	}
	return result
}
