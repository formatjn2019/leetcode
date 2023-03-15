package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaximalNetworkRank(t *testing.T) {
	//problems.MaximalNetworkRank(4, tools.ParseArr("[[0,1],[0,3],[1,2],[1,3]]"))
	//problems.MaximalNetworkRank(5, tools.ParseArr("[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]"))
	//problems.MaximalNetworkRank(8, tools.ParseArr("[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]"))
	problems.MaximalNetworkRank(5, tools.ParseArr("[[2,3],[0,3],[0,4],[4,1]]"))
}
