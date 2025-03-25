package test

import (
	"src/problems"
	"testing"
)

func TestDiagonalPrime(t *testing.T) {
	println(problems.DiagonalPrime([][]int{{503, 503}, {503, 503}}))
	println(problems.DiagonalPrime([][]int{{841}}))
}
