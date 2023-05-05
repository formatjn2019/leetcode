package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestHardestWorker(t *testing.T) {
	println(problems.HardestWorker(26, tools.ParseArr("[[1,1],[3,7],[2,12],[7,17]]")))
}
