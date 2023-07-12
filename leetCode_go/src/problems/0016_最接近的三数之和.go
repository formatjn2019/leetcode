package problems

import (
	"math"
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	//diff = target-sum
	minCloset, diff := 1<<30, target-(1<<30)
	for start, num := range nums {
		for lp, rp := start+1, len(nums)-1; lp < rp; {
			sum := num + nums[lp] + nums[rp]
			if nclost := int(math.Abs(float64(target - sum))); nclost < minCloset {
				minCloset = nclost
				diff = target - sum
			}
			if sum > target {
				rp--
			} else {
				lp++
			}
		}
	}
	return target - diff
}
