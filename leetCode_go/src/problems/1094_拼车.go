package problems

import "sort"

func carPooling(trips [][]int, capacity int) bool {
	orderArr := make([][2]int, 0, len(trips)*2)
	for _, trip := range trips {
		orderArr = append(orderArr, [2]int{trip[1], trip[0]})
		orderArr = append(orderArr, [2]int{trip[2], -trip[0]})
	}
	sort.Slice(orderArr, func(i, j int) bool {
		if orderArr[i][0] < orderArr[j][0] {
			return true
		} else if orderArr[i][0] == orderArr[j][0] && orderArr[i][1] < orderArr[j][1] {
			return true
		}
		return false
	})

	for _, oa := range orderArr {
		capacity -= oa[1]
		if capacity < 0 {
			return false
		}
	}
	return true
}
