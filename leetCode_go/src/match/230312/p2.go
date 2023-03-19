package _30312

import "sort"

func maxScore(nums []int) int {
	sort.Ints(nums)
	result := 0
	sum := 0
	for i := len(nums) - 1; i >= 0; i-- {
		sum += nums[i]
		if sum > 0 {
			result++
		} else {
			break
		}
	}
	return result
}
