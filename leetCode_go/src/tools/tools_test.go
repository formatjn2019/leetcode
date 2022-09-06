package tools

import (
	"fmt"
	"testing"
)

func TestParseTree(t *testing.T) {
	root := ParseTree("[5,4,5,1,1,null,5]")
	fmt.Printf("ParseTree(\"[5,4,5,1,1,null,5]\")\n")
	ShowTree(root)
}
