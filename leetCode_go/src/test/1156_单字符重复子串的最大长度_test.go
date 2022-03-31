package test

import (
	"src/problems"
	"testing"
)

func TestMaxRepOpt1(t *testing.T) {
	problems.MaxRepOpt1("ababaa")
	problems.MaxRepOpt1("aaabaaa")
	problems.MaxRepOpt1("aaabbaaa")
	problems.MaxRepOpt1("aaaaa")
}
