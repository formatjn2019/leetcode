package problems

import (
	"sort"
)

func FillCups(amount []int) int {
	print(fillCups(amount) == fillCups_simulation(amount))
	return fillCups(amount)
}

// 贪心
func fillCups(amount []int) int {
	sort.Ints(amount)
	if amount[2] >= amount[1]+amount[0] {
		return amount[2]
	} else {
		return (amount[0] + amount[1] + amount[2] + 1) / 2
	}
}

// 模拟
func fillCups_simulation(amount []int) int {
	sort.Ints(amount)
	result := 0
	for amount[1] > 0 {
		amount[2] -= 1
		amount[1] -= 1
		result++
		sort.Ints(amount)
	}
	result += amount[2]
	return result
}
