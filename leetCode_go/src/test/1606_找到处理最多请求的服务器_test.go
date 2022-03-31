package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestBusiestServers(t *testing.T) {
	fmt.Println(problems.BusiestServers(3, []int{1, 2, 3, 4, 5}, []int{5, 2, 3, 3, 3}))
	fmt.Println(problems.BusiestServers(3, []int{1, 2, 3, 4}, []int{1, 2, 1, 2}))
	fmt.Println(problems.BusiestServers(3, []int{1, 2, 3}, []int{10, 12, 11}))
	fmt.Println(problems.BusiestServers(3, []int{1, 2, 3, 4, 8, 9, 10}, []int{5, 2, 10, 3, 1, 2, 2}))
	fmt.Println(problems.BusiestServers(1, []int{1}, []int{1}))
}