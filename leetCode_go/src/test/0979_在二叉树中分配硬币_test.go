package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestDistributeCoins(t *testing.T) {
	println(problems.DistributeCoins(tools.ParseTree("[3,0,0]")))
	println(problems.DistributeCoins(tools.ParseTree("[0,3,0]")))
	println(problems.DistributeCoins(tools.ParseTree("[1,0,2]")))
	println(problems.DistributeCoins(tools.ParseTree("[1,0,0,-1,3]")))
}
