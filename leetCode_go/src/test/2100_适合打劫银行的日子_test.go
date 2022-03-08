package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestGoodDaysToRobBank(t *testing.T) {
	fmt.Println(problems.GoodDaysToRobBank([]int{5, 3, 3, 3, 5, 6, 2, 3, 23, 32, 2, 1, 4, 9, 4, 2, 5, 3, 3, 3, 5, 6, 2}, 2))
}
