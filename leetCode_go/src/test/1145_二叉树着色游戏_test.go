package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestBtreeGameWinningMove(t *testing.T) {
	// problems.BtreeGameWinningMove(tools.ParseTree("[1,2,3,4,5,6,7,8,9,10,11]"), 11, 3)
	fmt.Printf("problems.BtreeGameWinningMove(tools.ParseTree(\"[1,2,3]\"), 3, 1): %v\n", problems.BtreeGameWinningMove(tools.ParseTree("[1,2,3]"), 3, 1))
}
