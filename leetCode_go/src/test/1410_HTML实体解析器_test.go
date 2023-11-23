package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestEntityParser(t *testing.T) {
	fmt.Println(problems.EntityParser("and I quote: &quot;...&quot;"))
}
