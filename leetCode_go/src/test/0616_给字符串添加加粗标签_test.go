package test

import (
	"src/problems"
	"testing"
)

func TestAddBoldTag(t *testing.T) {
	println(problems.AddBoldTag("abcxyz123", []string{"abc", "123"}))
	println(problems.AddBoldTag("aaabbb", []string{"aa", "b"}))
}
