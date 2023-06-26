package test

import (
	"src/problems"
	"testing"
)

func TestFlipChess(t *testing.T) {
	println(problems.FlipChess([]string{"....X.", "....X.", "XOOO..", "......", "......"}))
	println(problems.FlipChess([]string{".X.", ".O.", "XO."}))
	println(problems.FlipChess([]string{".......", ".......", ".......", "X......", ".O.....", "..O....", "....OOX"}))
}
