package test

import (
	"src/problems"
	"testing"
)

func TestLongestStrChain(t *testing.T) {
	problems.LongestStrChain([]string{"a", "b", "ba", "bca", "bda", "bdca"})
	problems.LongestStrChain([]string{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"})
	problems.LongestStrChain([]string{"abcd", "dbqca"})
}
