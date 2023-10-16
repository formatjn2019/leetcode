package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestSingleNumber(t *testing.T) {
	fmt.Println(problems.SingleNumber([]int{-1638685546, -2084083624, -307525016, -930251592, -1638685546, 1354460680, 623522045, -1370026032, -307525016, -2084083624, -930251592, 472570145, -1370026032, 1063150409, 160988123, 1122167217, 1145305475, 472570145, 623522045, 1122167217, 1354460680, 1145305475}))
	fmt.Println(problems.SingleNumber([]int{0, 0, 1, 2}))
	fmt.Println(problems.SingleNumber([]int{1, 2, 1, 3, 2, 5}))
	fmt.Println(problems.SingleNumber([]int{-1, 0}))
	fmt.Println(problems.SingleNumber([]int{1, 0}))
}
