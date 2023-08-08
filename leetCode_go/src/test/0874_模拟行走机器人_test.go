package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestRobotSim(t *testing.T) {
	problems.RobotSim([]int{4, -1, 4, -2, 4}, tools.ParseArr("[[2,4]]"))
}
