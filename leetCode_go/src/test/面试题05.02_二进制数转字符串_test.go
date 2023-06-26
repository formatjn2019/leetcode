package test

import (
	"src/problems"
	"testing"
)

func TestPrintBin(t *testing.T) {
	println(problems.PrintBin(0.625))
	println(problems.PrintBin(0.1))
	println(problems.PrintBin(0.224))
}
