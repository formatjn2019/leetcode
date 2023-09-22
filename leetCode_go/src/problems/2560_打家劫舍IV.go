package problems

import (
	"fmt"
)

func MinCapability(nums []int, k int) int {
	return minCapability(nums, k)
}
func minCapability(nums []int, k int) int {
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

	minNum, MaxNum := nums[0], nums[0]
	for _, num := range nums {
		minNum = min(num, minNum)
		MaxNum = max(num, MaxNum)
	}

	for minNum <= MaxNum {
		mid := (minNum + MaxNum) / 2
		preChecked := false
		count := 0
		for _, num := range nums {
			if preChecked {
				preChecked = false
			} else if num <= mid {
				count++
				preChecked = true
			}
		}
		if count >= k {
			MaxNum = mid - 1
		} else {
			minNum = mid + 1
		}
	}
	return minNum
}

func minCapability_dp_error(nums []int, k int) int {

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
	if k == 1 {
		minNum := nums[0]
		for _, num := range nums {
			minNum = min(num, minNum)
		}
		return minNum
	}
	n := len(nums)
	matrix := make([][][2]int, k+1)

	//初始化矩阵
	for i := 0; i <= k; i++ {
		matrix[i] = make([][2]int, n+1)
		for j := 0; j <= n; j++ {
			matrix[i][j][0] = 1 << 31
		}
	}

	// 首层初始化
	for i := 1; i <= n; i++ {
		matrix[1][i][0] = nums[i-1]
		matrix[1][i][1] = nums[i-1]
	}
	for i := 2; i <= k; i++ {
		j := i*2 - 1
		matrix[i][j][0] = matrix[i-1][j-2][0] + nums[j-1]
		matrix[i][j][1] = max(matrix[i-1][j-2][1], nums[j-1])
	}

	//后续初始化
	for i := 2; i <= k; i++ {
		preMin := matrix[i-1][2*i-3]
		for j := 2 * i; j <= n; j++ {
			if preMin[1] > matrix[i-1][j-2][1] {
				preMin = matrix[i-1][j-2]
			}
			if preMin[0]+nums[j-1] == matrix[i][j-1][0] {
				matrix[i][j][0] = matrix[i][j-1][0]
				matrix[i][j][1] = min(matrix[i][j-1][1], max(preMin[1], nums[j-1]))
			} else if preMin[0]+nums[j-1] > matrix[i][j-1][0] {
				matrix[i][j][0] = matrix[i][j-1][0]
				matrix[i][j][1] = matrix[i][j-1][1]
			} else {
				matrix[i][j][0] = preMin[0] + nums[j-1]
				matrix[i][j][1] = max(preMin[1], nums[j-1])
			}
		}
	}

	for _, arr := range matrix {
		fmt.Println(arr)
	}
	return matrix[k][n][1]
}

func minCapability_timeout(nums []int, k int) int {
	maxSum := int(int64(1<<63 - 1))
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
	var result int
	n := len(nums)
	var dfs func(idx, remain, sum, maxValue int, preSelected bool)
	dfs = func(idx, remain, sum, maxValue int, preSelected bool) {
		if sum > maxSum {
			return
		}
		if idx == n {
			if remain == 0 {
				if sum < maxSum {
					maxSum = sum
					result = maxValue
				} else if sum == maxSum {
					result = min(result, maxValue)
				}
			}
			return
		}
		// 当前可选中
		if !preSelected {
			dfs(idx+1, remain-1, sum+nums[idx], max(maxValue, nums[idx]), true)
		}
		dfs(idx+1, remain, sum, maxValue, false)

	}
	dfs(0, k, 0, 0, false)
	return result
}
