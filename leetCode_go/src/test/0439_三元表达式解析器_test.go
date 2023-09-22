package test

import (
	"src/problems"
	"testing"
)

func TestParseTernary(t *testing.T) {
	println(problems.ParseTernary("T?T?F:5:3"))
	println(problems.ParseTernary("F?1:T?4:5"))
	println(problems.ParseTernary("T?2:3"))
}
