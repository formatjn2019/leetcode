package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestCanFormArray(t *testing.T) {
	fmt.Printf("problems.CanFormArray([]int{15, 88}, [][]int{{88}, {15}}): %v\n", problems.CanFormArray([]int{15, 88}, [][]int{{88}, {15}}))
	fmt.Printf("problems.CanFormArray([]int{49, 18, 16}, tools.ParseArr(\"[[16,18,49]]\")): %v\n", problems.CanFormArray([]int{49, 18, 16}, tools.ParseArr("[[16,18,49]]")))
	fmt.Printf("problems.CanFormArray([]int{91, 4, 64, 78}, tools.ParseArr(\"[[78],[4,64],[91]]\")): %v\n", problems.CanFormArray([]int{91, 4, 64, 78}, tools.ParseArr("[[78],[4,64],[91]]")))
}
