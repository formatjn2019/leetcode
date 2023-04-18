package test

import (
	"src/problems"
	"testing"
)

func TestCamelMatch(t *testing.T) {
	problems.CamelMatch([]string{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB")
}
