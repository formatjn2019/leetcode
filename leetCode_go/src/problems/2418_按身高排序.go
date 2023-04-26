package problems

import (
	"fmt"
)

func SortPeople(names []string, heights []int) []string {
	result := sortPeople(names, heights)
	fmt.Println(names)
	return result
}
func sortPeople(names []string, heights []int) []string {
	n := len(heights)
	//直接选择排序
	for i := 0; i < n; i++ {
		maxIndex := i
		for j := i + 1; j < n; j++ {
			if heights[j] > heights[maxIndex] {
				maxIndex = j
			}
		}
		names[i], names[maxIndex] = names[maxIndex], names[i]
		heights[i], heights[maxIndex] = heights[maxIndex], heights[i]
	}
	return names
}
