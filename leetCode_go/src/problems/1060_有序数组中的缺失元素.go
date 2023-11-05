package problems

import (
	"fmt"
	"strings"
)

func missingElement_enum(nums []int, k int) int {
	start := nums[0]
	for lp := 0; k > 0; start++ {
		if lp < len(nums) && nums[lp] == start {
			lp++
			continue
		}
		k--
	}
	return start - 1
}

func MissingElement(nums []int, k int) int {
	fmt.Println(strings.Repeat("*", 100))
	return missingElement(nums, k)
}
func missingElement(nums []int, k int) int {
	lp, rp := 0, len(nums)
	var idx int
	for lp < rp {
		mid := (lp + rp) / 2
		dif := nums[mid] - nums[0] - mid + 1
		if dif > k {
			rp = mid
		} else {
			idx = mid
			lp = mid + 1
		}
	}
	return k - (nums[idx] - nums[0] - idx) + nums[idx]
}
