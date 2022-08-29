package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestShuffle(t *testing.T) {
	fmt.Println(problems.Shuffle([]int{1, 2, 3, 4, 5, 6}, 3))
}
