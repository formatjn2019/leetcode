package problems

import "sort"

func wiggleSort(nums []int) {
	sort.Ints(nums)
	//不符合位置
	for i := 1; i < len(nums)-1; i += 2 {
		nums[i], nums[i+1] = nums[i+1], nums[i]
	}
}
