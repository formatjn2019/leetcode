package problems

func countPairs(nums []int, target int) int {
	var result int
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] < target {
				result++
			}
		}
	}
	return result
}
