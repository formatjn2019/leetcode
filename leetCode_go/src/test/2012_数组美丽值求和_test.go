package test

import (
	"src/problems"
	"testing"
)

func TestSumOfBeauties(t *testing.T){
	problems.SumOfBeauties([]int{1,2,3})
	problems.SumOfBeauties([]int{2,4,6,4})
	problems.SumOfBeauties([]int{0,2,4,4,6,8})
}