package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMissingRolls(t *testing.T) {
	fmt.Println(problems.MissingRolls([]int{3, 2, 4, 3}, 4, 2))
}