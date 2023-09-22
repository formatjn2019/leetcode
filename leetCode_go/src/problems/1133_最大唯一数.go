package problems

func largestUniqueNumber(nums []int) int {
	result := -1
	arrayCount := make([]int, 1001)
	for _, num := range nums {
		arrayCount[num]++
	}
	for i := len(arrayCount) - 1; i >= 0; i-- {
		if arrayCount[i] == 1 {
			result = i
			break
		}
	}
	return result
}
