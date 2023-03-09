package test

import (
	"src/problems"
	"testing"
)

func TestMinimumRecolors(t *testing.T) {
	println(problems.MinimumRecolors("WBBWWBBWBW", 7))
	println(problems.MinimumRecolors("WBWBBBW", 2))
	println(problems.MinimumRecolors("WWBBBWBBBBBWWBWWWB", 16))
}
