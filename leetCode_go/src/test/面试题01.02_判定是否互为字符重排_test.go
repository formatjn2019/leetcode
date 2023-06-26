package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestCheckPermutation(t *testing.T) {
	fmt.Printf("problems.CheckPermutation(\"abc\", \"acb\"): %v\n", problems.CheckPermutation("abc", "acb"))
	fmt.Printf("problems.CheckPermutation(\"问纷纷\", \"纷纷问\"): %v\n", problems.CheckPermutation("问", "纷纷问"))
}
