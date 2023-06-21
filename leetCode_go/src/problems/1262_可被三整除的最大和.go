package problems

import (
	"sort"
)

func MaxSumDivThree(nums []int) int {
	return maxSumDivThree(nums)
}

func maxSumDivThree(nums []int) int {
	sort.Ints(nums)
	sum, remain1Arr, remain2Arr := 0, make([]int, 0, 2), make([]int, 0, 2)
	for _, num := range nums {
		sum += num
		if num%3 == 1 && len(remain1Arr) < 2 {
			remain1Arr = append(remain1Arr, num)
		}
		if num%3 == 2 && len(remain2Arr) < 2 {
			remain2Arr = append(remain2Arr, num)
		}
	}
	switch sum % 3 {
	case 1:
		//-一个最小的1 或者减两个最小的2
		diff := sum
		if len(remain1Arr) > 0 && diff > remain1Arr[0] {
			diff = remain1Arr[0]
		}
		if len(remain2Arr) > 1 && diff > remain2Arr[0]+remain2Arr[1] {
			diff = remain2Arr[0] + remain2Arr[1]
		}
		return sum - diff
	case 2:
		//-一个最小的2 或者减两个最小的1
		diff := sum
		if len(remain2Arr) > 0 && diff > remain2Arr[0] {
			diff = remain2Arr[0]
		}
		if len(remain1Arr) > 1 && diff > remain1Arr[0]+remain1Arr[1] {
			diff = remain1Arr[0] + remain1Arr[1]
		}
		return sum - diff
	default:
		return sum
	}
}
