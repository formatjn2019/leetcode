package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestAnswerQueries(test *testing.T) {
	fmt.Println(problems.AnswerQueries([]int{8, 1, 6, 9, 3, 7, 2, 5, 4}, []int{3, 5, 7, 9, 11, 13, 15, 18, 19, 32}))
}
