package test

import (
	"src/problems"
	"testing"
)

func TestValidateStackSequences(t *testing.T) {
	problems.ValidateStackSequences([]int{1, 2, 3, 4, 5}, []int{4, 5, 3, 2, 1})
	problems.ValidateStackSequences([]int{1, 2, 3, 4, 5}, []int{4, 3, 5, 1, 2})
}
