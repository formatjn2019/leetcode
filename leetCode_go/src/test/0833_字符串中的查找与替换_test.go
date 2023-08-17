package test

import (
	"src/problems"
	"testing"
)

func TestFindReplaceString(t *testing.T) {
	println(problems.FindReplaceString("abcde", []int{2, 2}, []string{"cdef", "bc"}, []string{"f", "fe"}))
	println(problems.FindReplaceString("vmokgggqzp", []int{3, 5, 1}, []string{"kg", "ggq", "mo"}, []string{"s", "so", "bfr"}))
	println(problems.FindReplaceString("abcd", []int{0, 2}, []string{"a", "cd"}, []string{"eee", "ffff"}))
}
