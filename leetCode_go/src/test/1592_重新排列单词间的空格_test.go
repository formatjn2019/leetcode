package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestReorderSpaces(t *testing.T) {
	fmt.Printf("problems.ReorderSpaces(\"  this   is  a sentence \"): %v\n", problems.ReorderSpaces("  this   is  a sentence "))
	fmt.Printf("problems.ReorderSpaces(\" practice   makes   perfect\"): %v\n", problems.ReorderSpaces(" practice   makes   perfect"))
	fmt.Printf("problems.ReorderSpaces(\"\"): %v\n", problems.ReorderSpaces(""))
	fmt.Printf("problems.ReorderSpaces(\"aaa\"): %v\n", problems.ReorderSpaces("aaa"))
	fmt.Printf("problems.ReorderSpaces(\" hello\"): %v\n", problems.ReorderSpaces(" hello"))
}
