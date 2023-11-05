package problems

func tupleSameProduct(nums []int) int {
	memMap := map[int]int{}
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			a, b := nums[i], nums[j]
			memMap[a*b]++
		}
	}
	var result int
	for _, con := range memMap {
		result += con * (con - 1) * 4
	}
	return result
}
