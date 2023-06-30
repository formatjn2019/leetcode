package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestReconstructMatrix(t *testing.T) {
	fmt.Println(problems.ReconstructMatrix(2, 1, []int{1, 1, 1}))
	fmt.Println(problems.ReconstructMatrix(2, 3, []int{2, 2, 1, 1}))
	fmt.Println(problems.ReconstructMatrix(5, 5, []int{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}))
}
