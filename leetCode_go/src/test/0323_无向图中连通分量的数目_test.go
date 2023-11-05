package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestCountComponents(t *testing.T) {
	//problems.CountComponents(10, tools.ParseArr("[[5,8],[3,5],[1,9],[4,5],[0,2],[7,8],[4,9]]"))
	//problems.CountComponents(3, tools.ParseArr("[[2,0],[2,1]]"))
	//problems.CountComponents(4, tools.ParseArr("[[2,3],[1,2],[1,3]]"))
	//problems.CountComponents(4, tools.ParseArr("[[0,1],[0,2],[1,2]]"))
	problems.CountComponents(5, tools.ParseArr("[[0,1],[1,2],[3,4]]"))
}
