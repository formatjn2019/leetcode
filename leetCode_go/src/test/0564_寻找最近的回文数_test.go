package test

import (
	"src/problems"
	"testing"
)

func TestNearestPalindromic(t *testing.T) {
	println(problems.NearestPalindromic("1837722381"))
	println(problems.NearestPalindromic("230"))
	println(problems.NearestPalindromic("123"))
	println(problems.NearestPalindromic("1223221"))
}
