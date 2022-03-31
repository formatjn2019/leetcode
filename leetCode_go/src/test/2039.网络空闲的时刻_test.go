package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestNetworkBecomesIdle(t *testing.T) {
	problems.NetworkBecomesIdle(tools.ParseArr("[[0,1],[1,2]]"),[]int{0,2,1})
	problems.NetworkBecomesIdle(tools.ParseArr("[[0,1],[1,2],[2,0]]"),[]int{0,1,1})
	//problems.NetworkBecomesIdle(tools.ParseArr("[[0,1],[1,2]]"),[]int{0,2,1})
}