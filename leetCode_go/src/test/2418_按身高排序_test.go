package test

import (
	"src/problems"
	"testing"
)

func TestSortPeople(t *testing.T) {
	problems.SortPeople([]string{"Mary", "John", "Emma"}, []int{180, 165, 170})
}
