package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMostPoints(t *testing.T){
	println(problems.MostPoints(tools.ParseArr("[[3,2],[4,3],[4,4],[2,5]]")))
	println(problems.MostPoints(tools.ParseArr("[[1,1],[2,2],[3,3],[4,4],[5,5]]")))
}