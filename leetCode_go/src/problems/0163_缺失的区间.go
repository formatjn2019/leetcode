package problems

import "sort"

func findMissingRanges(nums []int, lower int, upper int) [][]int {
	nums = append(nums, lower-1, upper+1)
	sort.Ints(nums)
	getRange := func(min, max int) ([]int, bool) {
		if min+1 >= max {
			return nil, false
		}
		return []int{min + 1, max - 1}, true
	}
	var result [][]int
	for i := 1; i < len(nums); i++ {
		if rg, ok := getRange(nums[i-1], nums[i]); ok {
			result = append(result, rg)
		}
	}
	return result
}
