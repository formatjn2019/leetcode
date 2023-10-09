package test

import (
	"src/problems"
	"testing"
)

func TestCalculat(t *testing.T) {
	problems.Calculate("9+(5-1)*2+16/2")
	//problems.Calculate("1+1")
	//problems.Calculate("6-4/2")
	//problems.Calculate("2*(5+5*2)/3+(6/2+8)")
}
