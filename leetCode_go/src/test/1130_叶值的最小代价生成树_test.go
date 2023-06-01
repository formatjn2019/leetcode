package test

import (
	"src/problems"
	"testing"
)

func TestMctFromLeafValues(t *testing.T) {
	println(problems.MctFromLeafValues([]int{6, 2, 4}))
	println(problems.MctFromLeafValues([]int{4, 11}))
	//problems.MctFromLeafValues([]int{})
}
