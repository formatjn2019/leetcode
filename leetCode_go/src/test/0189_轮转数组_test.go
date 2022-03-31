package test

import (
	"src/problems"
	"testing"
)

func TestRotate(t *testing.T) {
	problems.Rotate([]int{1,2,3,4,5,6,7},3)
	problems.Rotate([]int{1,2,3,4,5,6},5)
	problems.Rotate([]int{1,2,3,4,5,6},4)
	problems.Rotate([]int{1,2,3,4,5,6},3)
	problems.Rotate([]int{1,2,3,4,5,6},2)
	problems.Rotate([]int{1,2,3,4,5,6},1)
	problems.Rotate([]int{1,2,3,4,5,6},0)
	problems.Rotate([]int{1 },0)
}