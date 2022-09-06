package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestFinalPrices(t *testing.T) {
	fmt.Printf("problems.FinalPrices([]int{1, 2, 3, 4, 5}): %v\n", problems.FinalPrices([]int{1, 2, 3, 4, 5}))
	fmt.Printf("problems.FinalPrices([]int{8, 4, 6, 2, 3}): %v\n", problems.FinalPrices([]int{8, 4, 6, 2, 3}))
	fmt.Printf("problems.FinalPrices([]int{10, 1, 1, 6}): %v\n", problems.FinalPrices([]int{10, 1, 1, 6}))
}
