package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestCountSubarrays(t *testing.T) {
	fmt.Println(problems.CountSubarrays([]int{2, 5, 1, 4, 3, 6}, 1))
	fmt.Println(problems.CountSubarrays([]int{2, 8, 3, 6, 1, 4, 5, 7}, 4))
}
