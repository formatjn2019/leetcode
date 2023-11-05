package problems

import "sort"

func highFive(items [][]int) [][]int {
	tpMap := map[int][]int{}
	for _, item := range items {
		tpMap[item[0]] = append(tpMap[item[0]], item[1])
	}
	idList := make([]int, 0, len(tpMap))
	sumMap := map[int]int{}
	for id, scores := range tpMap {
		sort.Ints(scores)
		sum, l := 0, len(scores)
		for i := 0; i < 5; i++ {
			sum += scores[l-i-1]
		}
		sumMap[id] = sum / 5
		idList = append(idList, id)
	}
	sort.Ints(idList)
	result := make([][]int, len(idList))
	for i, id := range idList {
		result[i] = []int{id, sumMap[id]}
	}
	return result
}
