package test

import (
	"src/problems"
	"testing"
)

func TestCanConstruct(t *testing.T) {
	println(problems.CanConstruct("a", "ab"))
	println(problems.CanConstruct("aa", "ab"))
	println(problems.CanConstruct("aa", "aab"))
}
