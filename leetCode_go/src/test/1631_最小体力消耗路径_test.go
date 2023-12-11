package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMinimumEffortPath(t *testing.T) {
	//println(problems.MinimumEffortPath(tools.ParseArr("[[3]]")))
	//println(problems.MinimumEffortPath(tools.ParseArr("[[1,2,2],[3,8,2],[5,3,5]]")))
	//println(problems.MinimumEffortPath(tools.ParseArr("[[1,2,3],[3,8,4],[5,3,5]]")))
	//println(problems.MinimumEffortPath(tools.ParseArr("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]")))
	println(problems.MinimumEffortPath(tools.ParseArr("[[4,3,4,10,5,5,9,2],[10,8,2,10,9,7,5,6],[5,8,10,10,10,7,4,2],[5,1,3,1,1,3,1,9],[6,4,10,6,10,9,4,6]]")))
}
