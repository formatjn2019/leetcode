package test

import (
	"src/problems"
	"testing"
)

func TestBraceExpansionII(t *testing.T) {
	//problems.BraceExpansionII("{a,b}{c,{d,e}}")
	problems.BraceExpansionII("{{a,z},a{b,c},{ab,z}}")
}
