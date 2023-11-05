package test

import (
	"src/problems"
	"testing"
)

func TestVerifyPreorder(t *testing.T) {
	problems.VerifyPreorder([]int{2, 1})
	//problems.VerifyPreorder([]int{5, 2, 3, 6})
}
