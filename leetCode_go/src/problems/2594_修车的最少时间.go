package problems

import (
	"math"
	"sort"
)

func RepairCars(ranks []int, cars int) int64 {
	return repairCars(ranks, cars)
}
func repairCars(ranks []int, cars int) int64 {
	min, max := int64(1), int64(ranks[0])*int64(cars)*int64(cars)+1
	var result int64
	for min < max {
		mid := (min + max) / 2
		if calculateRepairCars(ranks, mid) >= int64(cars) {
			result = mid
			max = mid
		} else {
			min = mid + 1
		}
	}
	return result
}

func calculateRepairCars(ranks []int, maxTime int64) int64 {
	result := int64(0)
	for _, r := range ranks {
		result += int64(math.Sqrt(float64(maxTime / int64(r))))
	}
	return result
}

func repairCars_timeout(ranks []int, cars int) int64 {
	//贪心剪枝
	sort.Ints(ranks)
	n := len(ranks)
	result := int64(ranks[n-1]) * int64(cars) * int64(cars)
	max := func(x, y int64) int64 {
		if x > y {
			return x
		}
		return y
	}
	var dfs func(current int64, idx, remain int)
	dfs = func(currentMax int64, idx, remain int) {
		if remain == 0 && currentMax <= result {
			result = currentMax
			return
		} else if currentMax > result || idx >= n {
			return
		}

		for i := remain; i > 0; i-- {
			dfs(max(currentMax, int64(ranks[idx])*int64(i)*int64(i)), idx+1, remain-i)
		}
	}
	dfs(0, 0, cars)
	return result
}
