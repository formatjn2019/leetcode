package problems

func mostFrequentEven(nums []int) int {
	result := -1
	countMap := map[int]int{}
	for _, num := range nums {
		if num%2 == 0 {
			countMap[num]++
			if countMap[num] > countMap[result] || (countMap[num] == countMap[result] && num < result) {
				result = num
			}
		}
	}
	return result
}
