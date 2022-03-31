package test

import (
	"src/problems"
	"src/tools"
	"testing"
)



func TestMinAreaFreeRect(t *testing.T) {
	problems.MinAreaFreeRect(tools.ParseArr("[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]"))
}