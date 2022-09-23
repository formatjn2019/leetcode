package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestKSimilarity(t *testing.T) {
	fmt.Printf("problems.KSimilarity(\"abc\", \"cba\"): %v\n", problems.KSimilarity("abc", "cba"))
	fmt.Printf("problems.KSimilarity(\"aabc\", \"cbaa\"): %v\n", problems.KSimilarity("aabc", "cbaa"))
	fmt.Printf("problems.KSimilarity(\"abc\", \"bca\"): %v\n", problems.KSimilarity("abc", "bca"))
	fmt.Printf("problems.KSimilarity(\"aa\", \"aa\"): %v\n", problems.KSimilarity("aa", "aa"))
	fmt.Printf("problems.KSimilarity(\"abccaacceecdeea\", \"bcaacceeccdeaae\"): %v\n", problems.KSimilarity("abccaacceecdeea", "bcaacceeccdeaae"))
}
