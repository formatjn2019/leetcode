package test

import (
	"src/problems"
	"testing"
)

func TestNextBeautifulNumber(t *testing.T) {
	println(problems.NextBeautifulNumber(1))
	println(problems.NextBeautifulNumber(9))
	println(problems.NextBeautifulNumber(1000))
	println(problems.NextBeautifulNumber(2000))
	println(problems.NextBeautifulNumber(3000))
	println(problems.NextBeautifulNumber(123329))
	println(problems.NextBeautifulNumber(1000000))
}
