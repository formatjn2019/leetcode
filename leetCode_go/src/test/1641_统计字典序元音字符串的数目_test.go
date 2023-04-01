package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestCountVowelStrings(t *testing.T) {
	for i := 1; i < 10; i++ {
		fmt.Println(problems.CountVowelStrings(i))
	}
}
