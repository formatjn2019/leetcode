package test

import (
	"src/problems"
	"testing"
)

func TestRepairCars(t *testing.T) {
	println(problems.RepairCars([]int{3}, 52))
	println(problems.RepairCars([]int{4, 2, 3, 1}, 10))
	println(problems.RepairCars([]int{5, 1, 8}, 6))
}
