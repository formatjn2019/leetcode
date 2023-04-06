package test

import (
	"src/problems"
	"testing"
)

func TestArithmeticTriplets(t *testing.T) {
	println(problems.ArithmeticTriplets([]int{0, 1, 4, 6, 7, 10}, 3))
	println(problems.ArithmeticTriplets([]int{4, 5, 6, 7, 8, 9, 10}, 2))
}
