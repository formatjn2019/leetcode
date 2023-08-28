package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestFlipLights(t *testing.T) {
	for i := 1; i < 10; i++ {
		for j := 1; j < 10; j++ {
			result := problems.FlipLights(i, j)
			fmt.Printf("n:  %d\tpreess: %d\t result:%d \n", i, j, result)
		}
	}
}
