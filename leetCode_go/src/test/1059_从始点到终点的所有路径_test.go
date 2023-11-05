package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestLeadsToDestination(t *testing.T) {
	problems.LeadsToDestination(5, tools.ParseArr("[[0,1],[0,2],[0,3],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]"), 0, 4)
	problems.LeadsToDestination(2, tools.ParseArr("[[1,0]]"), 0, 1)
	problems.LeadsToDestination(4, tools.ParseArr("[[0,1],[0,2],[1,3],[2,3]]"), 0, 3)
}
