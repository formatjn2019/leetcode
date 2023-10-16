package problems

import (
	"math"
)

func FindTheArrayConcVal(nums []int) int64 {
	return findTheArrayConcVal(nums)
}

func findTheArrayConcVal(nums []int) int64 {
	getVal := func(l, r int) int64 {
		return int64(l)*int64(math.Pow10(int(math.Log10(float64(r))+1))) + int64(r)
	}
	var result int64
	for ; len(nums) > 1; nums = nums[1 : len(nums)-1] {
		result += getVal(nums[0], nums[len(nums)-1])
	}
	if len(nums) > 0 {
		result += getVal(0, nums[0])
	}
	return result
}
