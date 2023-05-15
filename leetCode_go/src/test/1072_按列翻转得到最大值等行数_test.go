package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaxEqualRowsAfterFlips(t *testing.T) {
	problems.MaxEqualRowsAfterFlips(tools.ParseArr("[[1,0,0,0,1,1,1,0,1,1,1],[1,0,0,0,1,0,0,0,1,0,0],[1,0,0,0,1,1,1,0,1,1,1],[1,0,0,0,1,0,0,0,1,0,0],[1,1,1,0,1,1,1,0,1,1,1]]"))
	problems.MaxEqualRowsAfterFlips(tools.ParseArr("[[0,1],[1,1]]"))
	problems.MaxEqualRowsAfterFlips(tools.ParseArr("[[0,1],[1,0]]"))
	problems.MaxEqualRowsAfterFlips(tools.ParseArr("[[0,0,0],[0,0,1],[1,1,0]]"))
}
