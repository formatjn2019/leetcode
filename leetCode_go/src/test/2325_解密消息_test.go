package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestDecodeMessage(t *testing.T) {
	fmt.Printf("problems.DecodeMessage(\"the quick brown fox jumps over the lazy dog\", \"vkbs bs t suepuv\"): %v\n", problems.DecodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"))
	fmt.Printf("problems.DecodeMessage(\"eljuxhpwnyrdgtqkviszcfmabo\", \"zwx hnfx lqantp mnoeius ycgk vcnjrdb\"): %v\n", problems.DecodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"))
}
