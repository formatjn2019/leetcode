package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaxTaxiEarnings(t *testing.T) {
	//println(problems.MaxTaxiEarnings(5, tools.ParseArr("[[2,5,4],[1,5,1]]")))
	println(problems.MaxTaxiEarnings(20, tools.ParseArr("[[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]")))
}
