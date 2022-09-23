package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestCanPartitionKSubsets(t *testing.T) {
	fmt.Printf("problems.CanPartitionKSubsets([]int{4, 10, 9, 10, 10, 4, 9, 7, 5, 8, 8, 4, 4, 5}, 1): %v\n", problems.CanPartitionKSubsets([]int{4, 10, 9, 10, 10, 4, 9, 7, 5, 8, 8, 4, 4, 5}, 1))

	fmt.Printf("problems.CanPartitionKSubsets([]int{5, 5, 5, 5}, 4): %v\n", problems.CanPartitionKSubsets([]int{5, 5, 5, 5}, 4))
	fmt.Printf("problems.CanPartitionKSubsets([]int{4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9}, 5): %v\n", problems.CanPartitionKSubsets([]int{4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9}, 5))
	fmt.Printf("problems.CanPartitionKSubsets([]int{[3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]}, 5): %v\n", problems.CanPartitionKSubsets([]int{3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269}, 5))
	fmt.Printf("problems.CanPartitionKSubsets([]int{1, 1, 1, 1, 2, 2, 2, 2}, 2): %v\n", problems.CanPartitionKSubsets([]int{1, 1, 1, 1, 2, 2, 2, 2}, 2))
	fmt.Printf("problems.CanPartitionKSubsets([]int{1, 1, 1, 1, 2, 2, 2, 2}, 4): %v\n", problems.CanPartitionKSubsets([]int{1, 1, 1, 1, 2, 2, 2, 2}, 4))
	fmt.Printf("problems.CanPartitionKSubsets([]int{4, 3, 2, 3, 5, 2, 1}, 4): %v\n", problems.CanPartitionKSubsets([]int{4, 3, 2, 3, 5, 2, 1}, 4))
	fmt.Printf("problems.CanPartitionKSubsets([]int{1,2,3,4}, 3): %v\n", problems.CanPartitionKSubsets([]int{1, 2, 3, 4}, 3))
	fmt.Printf("problems.CanPartitionKSubsets([]int{2, 2, 2, 2, 3, 4, 5}, 4): %v\n", problems.CanPartitionKSubsets([]int{2, 2, 2, 2, 3, 4, 5}, 4))
	fmt.Printf("problems.CanPartitionKSubsets([]int{2,2,2,2,3,4,5}, 4): %v\n", problems.CanPartitionKSubsets([]int{2, 2, 2, 2, 3, 4, 5}, 4))

}
