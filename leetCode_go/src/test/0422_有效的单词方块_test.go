package test

import (
	"src/problems"
	"testing"
)

func TestValidWordSquare(t *testing.T) {
	problems.ValidWordSquare([]string{"ball", "asee", "let", "lep"})
	problems.ValidWordSquare([]string{"ball", "asee", "let", "lep"})
}
