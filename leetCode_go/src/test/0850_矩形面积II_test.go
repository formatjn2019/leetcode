package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestRectangleArea(t *testing.T) {

	problems.RectangleArea(tools.ParseArr("[[0,0,2,2],[1,0,2,3],[1,0,3,1]]"))
}
