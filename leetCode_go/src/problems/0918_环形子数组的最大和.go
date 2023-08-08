package problems

func MaxSubarraySumCircular(nums []int) int {
	return maxSubarraySumCircular(nums)
}

func maxSubarraySumCircular(nums []int) int {
	min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	sum, preMinSum, preMaxSum, minSum, maxSum := 0, 0, 0, nums[0], nums[0]
	for _, num := range nums {
		sum += num
		preMaxSum = max(preMaxSum+num, num)
		preMinSum = min(preMinSum+num, num)
		minSum = min(minSum, preMinSum)
		maxSum = max(maxSum, preMaxSum)
	}
	if maxSum < 0 || maxSum > sum-minSum {
		return maxSum
	}
	return sum - minSum
}

func maxSubarraySumCircular_timeout(nums []int) int {
	result, n := -1<<31, len(nums)
	for lp, num := range nums {
		sum := num
		if sum > result {
			result = sum
		}
		for rp := (lp + 1) % n; sum > 0 && lp != rp; rp = (rp + 1) % n {
			sum += nums[rp]
			if sum > result {
				result = sum
			}
		}
	}
	return result
}
