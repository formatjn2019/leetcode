package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestCheckValidGrid(t *testing.T) {
	problems.CheckValidGrid(tools.ParseArr("[[24,11,22,17,4],[21,16,5,12,9],[6,23,10,3,18],[15,20,1,8,13],[0,7,14,19,2]]"))
	problems.CheckValidGrid(tools.ParseArr("[[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]"))
	problems.CheckValidGrid(tools.ParseArr("[[0,3,6],[5,8,1],[2,7,4]]"))
}
