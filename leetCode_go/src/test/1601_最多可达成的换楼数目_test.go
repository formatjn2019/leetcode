package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaximumRequests(t *testing.T) {

	//maximumRequests(5, [][]int{{0, 1}, {1, 0}, {1, 2}, {0, 1}, {2, 0}, {3, 4}})
	//	4
	//[[3,0],[2,2],[3,0],[0,1],[1,2],[0,0],[3,2],[1,2]]
	requests := problems.MaximumRequests(4, tools.ParseArr("[[3,0],[2,2],[3,0],[0,1],[1,2],[0,0],[3,2],[1,2]]"))
	println(requests)
}
