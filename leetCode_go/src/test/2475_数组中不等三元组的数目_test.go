package test

import (
	"src/problems"
	"testing"
)

func TestUnequalTriplets(t *testing.T) {
	problems.UnequalTriplets([]int{4, 4, 2, 4, 3})
	problems.UnequalTriplets([]int{1, 1, 1, 1, 1})
	//problems.UnequalTriplets([]int{})
	//problems.UnequalTriplets([]int{})
}
