package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestGenerateMatrix(t *testing.T) {
	fmt.Println(problems.GenerateMatrix(1))
	fmt.Println(problems.GenerateMatrix(3))
	fmt.Println(problems.GenerateMatrix(4))
}
