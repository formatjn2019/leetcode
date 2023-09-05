package problems

func minNumber(nums1 []int, nums2 []int) int {
	countMap := map[int]bool{}
	min1, min2 := 10, 10
	result := 1000
	for _, num := range nums1 {
		countMap[num] = true
		if min1 > num {
			min1 = num
		}
	}
	for _, num := range nums2 {
		if _, ok := countMap[num]; ok && num < result {
			result = num
		}
		if min2 > num {
			min2 = num
		}
	}
	if min1 > min2 {
		min2, min1 = min1, min2
	}
	if min1*10+min2 < result {
		result = min1*10 + min2
	}
	return result
}
