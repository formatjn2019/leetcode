package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestBestHand(t *testing.T) {
	fmt.Printf("problems.BestHand([]int{13, 2, 3, 1, 9}, []byte{'a', 'a', 'a', 'a', 'a'}): %v\n", problems.BestHand([]int{13, 2, 3, 1, 9}, []byte{'a', 'a', 'a', 'a', 'a'}))
	fmt.Printf("problems.BestHand([]int{4, 4, 2, 4, 4}, []byte{'d', 'a', 'a', 'b', 'c'}): %v\n", problems.BestHand([]int{4, 4, 2, 4, 4}, []byte{'d', 'a', 'a', 'b', 'c'}))
	fmt.Printf("problems.BestHand([]int{10, 10, 2, 12, 9}, []byte{'a', 'b', 'c', 'a', 'd'}): %v\n", problems.BestHand([]int{10, 10, 2, 12, 9}, []byte{'a', 'b', 'c', 'a', 'd'}))
}
