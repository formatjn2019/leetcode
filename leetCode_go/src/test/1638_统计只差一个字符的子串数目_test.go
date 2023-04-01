package test

import (
	"src/problems"
	"testing"
)

func TestCountSubstrings(t *testing.T) {
	println(problems.CountSubstrings("aba", "baba"))
	println(problems.CountSubstrings("ab", "bb"))
	println(problems.CountSubstrings("a", "a"))
	println(problems.CountSubstrings("abe", "bbc"))
}
