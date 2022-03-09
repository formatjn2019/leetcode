package problems

import (
	"fmt"
)

func BestRotation(nums []int) int {
	return bestRotation(nums)
}

func bestRotation(nums []int) int {
	lenth := len(nums)
	//差分数组
	difference := make([]int, lenth)
	//比较
	for i, n := range nums {
		start := (lenth + i - (lenth - 1)) % lenth
		end := lenth + i - n
		difference[start]++
		if end < lenth {
			if end+1 < lenth {
				difference[end+1]--
			}
		} else {
			difference[0]++
			difference[(end+1)%lenth]--
		}
	}
	//找结果
	max, pre, result := -1, 0, 0
	for i, n := range difference {
		pre += n
		if pre > max {
			max = pre
			result = i
		}
	}
	return result
}

//暴力法
func bestRotation_enum(nums []int) int {
	lenth := len(nums)
	results := make([]int, lenth)
	//比较
	for i, n := range nums {
		for j := 0; j < lenth; j++ {
			nIndex := (i - j + lenth) % lenth
			if nIndex >= n {
				results[j]++
			}
		}
	}
	fmt.Println(results)
	//找结果
	max, result := -1, 0
	for i, n := range results {
		if n > max {
			max = n
			result = i
		}
	}
	return result
}
