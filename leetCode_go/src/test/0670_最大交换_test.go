package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMaximumSwap(t *testing.T) {
	fmt.Printf("problems.MaximumSwap(1234): %v\n", problems.MaximumSwap(1234))
	fmt.Printf("problems.MaximumSwap(4321): %v\n", problems.MaximumSwap(4321))
	fmt.Printf("problems.MaximumSwap(2736): %v\n", problems.MaximumSwap(2736))
}
