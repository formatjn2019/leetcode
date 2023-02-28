package problems

import (
	"fmt"
	"sort"
)

func MergeSimilarItems(items1 [][]int, items2 [][]int) [][]int {
	result := mergeSimilarItems(items1, items2)
	fmt.Println(items1, items2, result)
	return result
}
func mergeSimilarItems(items1 [][]int, items2 [][]int) [][]int {
	valueWeightMap := map[int]int{}
	for _, arr := range items1 {
		valueWeightMap[arr[0]] = valueWeightMap[arr[0]] + arr[1]
	}
	for _, arr := range items2 {
		valueWeightMap[arr[0]] = valueWeightMap[arr[0]] + arr[1]
	}
	result := make([][]int, 0, len(valueWeightMap))
	for k, v := range valueWeightMap {
		result = append(result, []int{k, v})
	}
	sort.Slice(result, func(i, j int) bool {
		return result[i][0] < result[j][0]
	})
	return result
}
