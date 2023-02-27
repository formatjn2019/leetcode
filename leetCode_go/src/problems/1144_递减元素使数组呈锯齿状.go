package problems

func MovesToMakeZigzag(nums []int) int {
	return movesToMakeZigzag(nums)
}

func movesToMakeZigzag(nums []int) int {
	getSub := func(idx int) int {
		min := nums[idx] + 1
		if idx-1 >= 0 && nums[idx-1] < min {
			min = nums[idx-1]
		}
		if idx+1 < len(nums) && nums[idx+1] < min {
			min = nums[idx+1]
		}
		return nums[idx] - min + 1
	}
	sum1, sum2 := 0, 0
	for i := 0; i < len(nums); i++ {
		if i%2 == 0 {
			sum1 += getSub(i)
		} else {
			sum2 += getSub(i)
		}
	}
	if sum1 < sum2 {
		return sum1
	}
	return sum2
}
