package test

import (
	"src/problems"
	"testing"
)

func TestCalculat(t *testing.T) {
	//fmt.Println(len("中的"))
	problems.Calculate("10/2/5")
	problems.Calculate("9+(3-1)*3+19/2")
	problems.Calculate("9+(5-1)*2+16/2")
	problems.Calculate("1+1")
	problems.Calculate("6-4/2")
	problems.Calculate("2*(5+5*2)/3+(6/2+8)")
}
