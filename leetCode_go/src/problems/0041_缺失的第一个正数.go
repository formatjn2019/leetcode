package problems

func FirstMissingPositive(nums []int) int {
	return firstMissingPositive(nums)
}

func firstMissingPositive(nums []int) int {
	n := len(nums)
	for i := 0; i < n; i++ {
		for nums[i] != i+1 {
			num := nums[i]
			if nums[i] <= 0 {
				break
			} else if nums[i] > n || nums[i] == nums[num-1] {
				nums[i] = -nums[i]
				break
			}
			nums[i], nums[num-1] = nums[num-1], nums[i]
		}
	}
	for i, num := range nums {
		if num <= 0 {
			return i + 1
		}
	}
	return n + 1
}
