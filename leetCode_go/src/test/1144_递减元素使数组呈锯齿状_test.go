package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMovesToMakeZigzag(*testing.T) {
	fmt.Printf("problems.MovesToMakeZigzag([]int{1, 2, 3}): %v\n", problems.MovesToMakeZigzag([]int{1, 2, 3}))
	fmt.Printf("problems.MovesToMakeZigzag([]int{9, 6, 1, 6, 2}): %v\n", problems.MovesToMakeZigzag([]int{9, 6, 1, 6, 2}))
}
