package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestFindElements(t *testing.T) {
	findElements := problems.ConstructorFind(tools.ParseTree("[-1,-1,-1,-1,-1]"))
	println(findElements.Find(1))
	println(findElements.Find(3))
	println(findElements.Find(5))

}
