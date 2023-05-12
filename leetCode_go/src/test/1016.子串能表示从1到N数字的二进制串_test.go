package test

import (
	"src/problems"
	"testing"
)

func TestQueryString(t *testing.T) {
	problems.QueryString("10010111100001110010", 10)
	problems.QueryString("0110", 3)
	problems.QueryString("0110", 4)
}
