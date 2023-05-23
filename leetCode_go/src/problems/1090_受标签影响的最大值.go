package problems

import (
	"sort"
)

func LargestValsFromLabels(values []int, labels []int, numWanted int, useLimit int) int {
	return largestValsFromLabels(values, labels, numWanted, useLimit)
}
func largestValsFromLabels(values []int, labels []int, numWanted int, useLimit int) int {
	n, result := len(labels), 0
	items, resultCount := make([][2]int, n), map[int]int{}
	for i, value := range values {
		items[i][0], items[i][1] = value, labels[i]
	}
	sort.Slice(items, func(i, j int) bool {
		return items[i][0] > items[j][0]
	})
	for i := 0; i < n && numWanted > 0; i++ {
		value, lable := items[i][0], items[i][1]
		if resultCount[lable] < useLimit {
			result += value
			resultCount[lable]++
			numWanted--
		}
	}
	return result
}
