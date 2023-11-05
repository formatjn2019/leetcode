package test

import (
	"src/problems"
	"testing"
)

func TestNumRollsToTarget(t *testing.T) {
	println(problems.NumRollsToTarget(1, 6, 3))
	println(problems.NumRollsToTarget(2, 6, 7))
	println(problems.NumRollsToTarget(30, 30, 500))
}
