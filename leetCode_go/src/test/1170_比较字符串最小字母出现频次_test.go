package test

import (
	"fmt"
	"src/problems"
	"testing"
)


func TestNumSmallerByFrequency(t *testing.T){
	fmt.Println(problems.NumSmallerByFrequency([]string{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"}, []string{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"}))
	fmt.Println(problems.NumSmallerByFrequency([]string{"bbb", "cc"}, []string{"a", "aa", "aaa", "aaaa"}))
	fmt.Println(problems.NumSmallerByFrequency([]string{"cbd"}, []string{ "zaaaz"}))
}