package problems

func MaxAbsoluteSum(nums []int) int {
	return maxAbsoluteSum_prefixSum(nums)
}

func maxAbsoluteSum(nums []int) int {
	abs := func(x int) int {
		if x > 0 {
			return x
		}
		return -x
	}
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	//前缀和
	prefixSum := make([]int, len(nums)+1)
	for idx, num := range nums {
		prefixSum[idx+1] = prefixSum[idx] + num
	}
	minSum, maxSum := 0, 0
	result := 0
	for idx, sum := range prefixSum {
		minSum = min(minSum, prefixSum[idx])
		maxSum = max(maxSum, prefixSum[idx])
		result = max(result, abs(sum-minSum))
		result = max(result, abs(sum-maxSum))
	}
	return result
}

func maxAbsoluteSum_prefixSum(nums []int) int {
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	for i := 1; i < len(nums); i++ {
		nums[i] += nums[i-1]
	}
	maxSum, minSum := 0, 0
	for _, sum := range nums {
		maxSum = max(maxSum, sum)
		minSum = min(minSum, sum)
	}
	return maxSum - minSum
}
