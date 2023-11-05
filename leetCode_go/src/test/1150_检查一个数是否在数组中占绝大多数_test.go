package test

import (
	"src/problems"
	"testing"
)

func TestIsMajorityElement(t *testing.T) {
	problems.IsMajorityElement([]int{10, 100, 101, 101}, 101)
}
