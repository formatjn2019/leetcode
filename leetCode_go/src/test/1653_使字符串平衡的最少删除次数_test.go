package test

import (
	"src/problems"
	"testing"
)

func TestMinimumDeletions(t *testing.T) {
	println("problems.MinimumDeletions(\"aababbab\")", problems.MinimumDeletions("aababbab"))
	println("problems.MinimumDeletions(\"bbaaaaabb\")", problems.MinimumDeletions("bbaaaaabb"))
	println("problems.MinimumDeletions(\"aabaababaabaaabbabaaba\")", problems.MinimumDeletions("aabaababaabaaabbabaaba"))
	println("problems.MinimumDeletions(\"aaa\")", problems.MinimumDeletions("aaa"))
	println("problems.MinimumDeletions(\"a\")", problems.MinimumDeletions("a"))
	println("problems.MinimumDeletions(\"b\")", problems.MinimumDeletions("b"))
	println("problems.MinimumDeletions(\"bbbb\")", problems.MinimumDeletions("bbbb"))
}
