package test

import (
	"fmt"
	"math"
	"src/problems"
	"testing"
)

func TestConstructArray(t *testing.T) {
	i := 9
	for j := 1; j < i; j++ {
		arr := problems.ConstructArray(i, j)
		fmt.Println(arr)
		fmt.Println(j, countDiff(arr))
	}

}

func countDiff(arr []int) int {
	count := map[int]bool{}
	for i := 0; i < len(arr)-1; i++ {
		count[int(math.Abs(float64(arr[i+1]-arr[i])))] = true
	}
	return len(count)
}
