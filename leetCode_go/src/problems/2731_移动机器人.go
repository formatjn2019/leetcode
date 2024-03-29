package problems

import "sort"

func SumDistance(nums []int, s string, d int) int {
	return sumDistance(nums, s, d)
}

func sumDistance(nums []int, s string, d int) int {
	for i, c := range []rune(s) {
		if c == 'L' {
			nums[i] -= d
		} else {
			nums[i] += d
		}
	}
	sort.Ints(nums)
	result := 0
	for i := 1; i < len(nums); i++ {
		result += (nums[i] - nums[i-1]) * i % 1000000007 * (len(nums) - i) % 1000000007
		result %= 1000000007
	}
	return result
}
