package test

import (
	"src/problems"
	"testing"
)

func TestFillCups(t *testing.T) {
	problems.FillCups([]int{1, 4, 2})
	problems.FillCups([]int{5, 4, 4})
	problems.FillCups([]int{5, 0, 0})
}
