package _30312

import (
	"fmt"
	"testing"
)

func beautifulSubarrays(nums []int) int64 {
	//prefixSum := make([]int, len(nums)+1)
	countMap := map[int]int{0: 1}
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum = add(sum, nums[i])
		countMap[sum]++
	}
	result := int64(0)
	for _, num := range countMap {
		if num > 1 {
			result += int64(num * (num - 1) / 2)
		}
	}
	return result
}

func add(x, y int) int {
	result := 0
	for exp := 0; 1<<exp <= x || 1<<exp <= y; exp++ {
		bit := (x >> exp % 2) ^ (y >> exp % 2)
		result |= bit << exp
	}
	return result
}

func beautifulSubarrays2(nums []int) int64 {
	prefixSum := make([]int, len(nums)+1)
	sum := 0
	for i := 0; i < len(nums); i++ {
		prefixSum[i] = sum
		sum = add(sum, nums[i])
	}
	prefixSum[len(nums)] = sum
	fmt.Println(prefixSum)
	result := int64(0)
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums)+1; j++ {
			if prefixSum[i] == prefixSum[j] {
				result++
			}
		}
	}
	return result
}

//func beautifulSubarrays(nums []int) int64 {
//	result := int64(0)
//	for i := 0; i < len(nums); i++ {
//		sum := 0
//		for j := i; j < len(nums); j++ {
//			sum = add(sum, nums[j])
//			if sum == 0 {
//				result++
//			}
//		}
//	}
//	return result
//}

func TestAdd(t *testing.T) {
	print(beautifulSubarrays2([]int{3, 4, 3, 1, 2, 4, 3, 1, 2}))
	print(beautifulSubarrays([]int{3, 4, 3, 1, 2, 4, 3, 1, 2}))
}
