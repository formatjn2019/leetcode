package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestSubsetsWithDup(t *testing.T) {
	dup := problems.SubsetsWithDup([]int{1, 2, 2})
	fmt.Println(dup)
}
