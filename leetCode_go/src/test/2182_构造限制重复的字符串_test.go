package test

import (
	"src/problems"
	"testing"
)

func TestRepeatLimitedString(t *testing.T) {
	println(problems.RepeatLimitedString("robnsdvpuxbapuqgopqvxdrchivlifeepy", 2))
	println(problems.RepeatLimitedString("cczazcc", 3))
	println(problems.RepeatLimitedString("aababab", 2))
}
