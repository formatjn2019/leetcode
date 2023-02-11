package test

import (
	"src/problems"
	"testing"
)

func TestDieSimulator(t *testing.T) {

	// problems.DieSimulator(2, []int{1, 1, 2, 2, 2, 3})
	// // problems.DieSimulator(3, []int{1, 1, 1, 2, 2, 3})
	// problems.DieSimulator(2, []int{1, 1, 1, 1, 1, 1})
	// problems.DieSimulator(4, []int{1, 1, 1, 2, 2, 3})
	// problems.DieSimulator(3, []int{2, 1, 1, 1, 1, 1})
	// problems.DieSimulator(4, []int{2, 1, 1, 1, 1, 1})
	// problems.DieSimulator(5, []int{2, 1, 1, 1, 1, 1})
	problems.DieSimulator(20, []int{8, 5, 10, 8, 7, 2})
}
