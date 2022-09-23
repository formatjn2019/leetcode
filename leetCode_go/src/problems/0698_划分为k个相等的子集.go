package problems

import (
	"fmt"
	"sort"
)

func CanPartitionKSubsets(nums []int, k int) bool {
	return canPartitionKSubsets(nums, k)
}

func canPartitionKSubsets(nums []int, k int) bool {
	if k == 1 {
		return true
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})
	sum := 0
	for _, num := range nums {
		sum += num
	}
	target := sum / k
	fmt.Println(nums)
	fmt.Println(target)
	if sum%k > 0 || target < nums[len(nums)-1] {
		return false
	}
	passed := map[int]bool{}
	// 穷举
	for i := 1; i < 1<<len(nums); i++ {
		tp := target
		for index, t := 0, i; t > 0; index++ {
			if t%2 == 1 {
				tp -= nums[index]
			}
			t >>= 1
		}
		if tp == 0 {
			passed[i] = true
		}
	}
	keys := make([]int, 0, len(passed))
	for k2 := range passed {
		keys = append(keys, k2)
	}

	//找出合适的组合
	var findNums func(int, int, []int) bool

	findNums = func(start, remain int, used []int) bool {
		if remain == 0 {
			tA := 0
			for _, num := range used {
				if tA&num == 0 {
					tA |= num
				} else {
					return false
				}

			}
			return tA == 1<<len(nums)-1
		}

		for i := start; i < len(keys)-remain+1; i++ {
			used[len(used)-remain] = keys[i]
			if findNums(i+1, remain-1, used) {
				return true
			}
		}
		return false
	}

	return findNums(0, k, make([]int, k))
}

func canPartitionKSubsets_error(nums []int, k int) bool {
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] > nums[j]
	})
	sum := 0
	for _, num := range nums {
		sum += num
	}
	target := sum / k
	fmt.Println(nums)
	fmt.Println(target)
	if sum%k > 0 || target < nums[len(nums)-1] {
		return false
	}
	used := make([]bool, len(nums))
	for i := 0; i < k; i++ {
		fmt.Println("次数", i)
		fmt.Println(used)

		if !findIndex(nums, used, target) {
			return false
		}
	}
	return true
}

func findIndex(arr []int, used []bool, target int) bool {
	var result []bool = nil
	tpUsed := make([]bool, len(arr))
	copy(tpUsed, used)
	var dfs func(int, int, []bool)
	dfs = func(depth, target int, used []bool) {
		if target == 0 && result == nil {
			result = make([]bool, len(used))
			copy(result, used)
			return
		} else if depth == len(arr) || result != nil {
			return
		}
		if !used[depth] && target >= arr[depth] {
			used[depth] = true
			dfs(depth+1, target-arr[depth], used)
			used[depth] = false
		}
		dfs(depth+1, target, used)
	}
	dfs(0, target, tpUsed)
	if result != nil {
		for i := 0; i < len(used); i++ {
			if used[i] != result[i] {
				fmt.Print(arr[i], "\t")
			}
		}

		copy(used, result)
		return true
	} else {
		return false
	}
}
