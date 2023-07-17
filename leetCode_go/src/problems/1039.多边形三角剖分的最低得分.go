package problems

import (
	"fmt"
	"sort"
)

func MinScoreTriangulation(values []int) int {
	return minScoreTriangulation(values)
}
func minScoreTriangulation(values []int) int {
	//贪心
	var greedy func([]int) int
	greedy = func(ints []int) int {
		switch len(ints) {
		case 2:
			return 0
		case 3:
			return ints[0] * ints[1] * ints[2]
		default:
			minArr := sortToIndex(ints)[:3]
			sort.Ints(minArr)
			sub1, sub2, sub3 := ints[minArr[0]:minArr[1]+1], ints[minArr[1]:minArr[2]+1], append(ints[minArr[2]:], ints[:minArr[0]+1]...)
			return ints[minArr[0]]*ints[minArr[1]]*ints[minArr[2]] + greedy(sub1) + greedy(sub2) + greedy(sub3)

		}
	}

	result := greedy(values)
	return result
}

func sortToIndex(arr []int) []int {
	tpArr := make([][2]int, len(arr))
	for i := 0; i < len(arr); i++ {
		tpArr[i][0] = i
		tpArr[i][1] = arr[i]
	}
	sort.Slice(tpArr, func(i, j int) bool {
		return tpArr[i][1] < tpArr[j][1]
	})
	result := make([]int, len(arr))
	for i := 0; i < len(tpArr); i++ {
		result[i] = tpArr[i][0]
	}
	fmt.Println(tpArr)
	return result
}
