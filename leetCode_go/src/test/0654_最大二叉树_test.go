package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestConstructMaximumBinaryTree(t *testing.T) {
	root := problems.ConstructMaximumBinaryTree([]int{3, 2, 1, 6, 0, 5})
	tools.ShowTree(root)
}
