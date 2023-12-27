package test

import (
	"src/problems"
	"testing"
)

func area(x int64) int64 {
	return 4*x*x*x + 5*x*x + 2*x
}

func TestMinimumPerimeter(t *testing.T) {
	//2784381467700
	expect := int64(37894501152718)
	println(area(169272 / 4))
	println(area(169272/4) > expect)
	println(problems.MinimumPerimeter(expect))
}
