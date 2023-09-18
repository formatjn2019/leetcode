package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestGroupStrings(t *testing.T) {
	fmt.Println(problems.GroupStrings([]string{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}))
	fmt.Println(problems.GroupStrings([]string{"a"}))
}
