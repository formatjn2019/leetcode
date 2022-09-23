package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestFrequencySort(t *testing.T) {
	fmt.Println("2333")
	fmt.Printf("problems.FrequencySort([]int{}): %v\n", problems.FrequencySort([]int{1, 1, 2, 2, 2, 3}))
	fmt.Printf("problems.FrequencySort([]int{}): %v\n", problems.FrequencySort([]int{2, 3, 1, 3, 2}))
	fmt.Printf("problems.FrequencySort([]int{}): %v\n", problems.FrequencySort([]int{-1, 1, -6, 4, 5, -6, 1, 4, 1}))
}
