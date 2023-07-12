package problems

import (
	"fmt"
	"strings"
)

func MaxAlternatingSum(nums []int) int64 {
	fmt.Println(strings.Repeat("*", 100))
	return maxAlternatingSum(nums)
}
func maxAlternatingSum(nums []int) int64 {
	max := func(x, y int64) int64 {
		if x > y {
			return x
		}
		return y
	}
	sum1, sum2 := int64(nums[0]), int64(0)
	for _, num := range nums[1:] {
		//选中 与不选中取最优
		sum2, sum1 = max(sum2, sum1-int64(num)), max(sum1, sum2+int64(num))
	}
	return max(sum2, sum1)
}
