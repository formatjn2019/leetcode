package test

import (
	"src/problems"
	"testing"
)

func TestInsertIntoMaxTree(t *testing.T) {
	problems.InsertIntoMaxTree(problems.ConstructMaximumBinaryTree([]int{1, 4, 2, 3}), 5)
	problems.InsertIntoMaxTree(problems.ConstructMaximumBinaryTree([]int{2, 1, 5, 4}), 3)
	problems.InsertIntoMaxTree(problems.ConstructMaximumBinaryTree([]int{2, 1, 5, 3}), 3)
}
