package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestCandyCrush(t *testing.T) {
	tools.ShowArray(problems.CandyCrush(tools.ParseArr("[[1,3,5,5,2],[3,4,3,3,1],[3,2,4,5,2],[2,4,4,5,5],[1,4,4,1,1]]")))
	//tools.ShowArray(problems.CandyCrush(tools.ParseArr("[[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]")))
}
