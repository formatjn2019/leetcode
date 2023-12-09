package problems

import (
	"math"
)

func MinimumFuelCost(roads [][]int, seats int) int64 {
	return minimumFuelCost(roads, seats)
}

func minimumFuelCost(roads [][]int, seats int) int64 {
	roadsQuery := make([][]int, len(roads)+1)
	for _, tArr := range roads {
		roadsQuery[tArr[0]] = append(roadsQuery[tArr[0]], tArr[1])
		roadsQuery[tArr[1]] = append(roadsQuery[tArr[1]], tArr[0])
	}
	//转换为层级字典
	levelMap := map[int][]int{}
	arr := []int{0}
	for len(arr) > 0 {
		newArr := []int{}
		for _, parent := range arr {
			for _, sub := range roadsQuery[parent] {
				if _, ok := levelMap[sub]; !ok {
					newArr = append(newArr, sub)
					levelMap[parent] = append(levelMap[parent], sub)
				}
			}
		}
		arr = newArr
	}
	//深度优先遍历
	var result int64
	var dfs func(node int) int
	dfs = func(node int) int {
		people := 0
		for _, sub := range levelMap[node] {
			people += dfs(sub)
		}
		if node != 0 {
			people++
			result += int64(math.Ceil(float64(people) / float64(seats)))
		}
		return people
	}
	dfs(0)
	return result
}
