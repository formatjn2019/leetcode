package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestGetKthMagicNumber(t *testing.T) {
	for i := 1; i < 18; i++ {
		fmt.Println(i, problems.GetKthMagicNumber(i))
	}
}
