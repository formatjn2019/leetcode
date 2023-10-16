package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestVerticalOrder(t *testing.T) {
	problems.VerticalOrder(tools.ParseTree("[]"))
	problems.VerticalOrder(tools.ParseTree("[3,9,20,-1,-1,15,7]"))
}
