package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestGiveGem(t *testing.T) {
	println(problems.GiveGem([]int{0, 2, 5, 4}, tools.ParseArr("[[3,2],[3,2],[1,3],[0,2],[3,0],[3,1],[0,3],[2,1],[3,0]]")))
	println(problems.GiveGem([]int{100, 0, 50, 100}, tools.ParseArr("[[0,2],[0,1],[3,0],[3,0]]")))
}
