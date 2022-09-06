package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestLongestUnivaluePath(t *testing.T) {
	problems.LongestUnivaluePath(tools.ParseTree("[5,4,5,1,1,null,5]"))
	problems.LongestUnivaluePath(tools.ParseTree("[1,4,5,4,4,5]"))
}
