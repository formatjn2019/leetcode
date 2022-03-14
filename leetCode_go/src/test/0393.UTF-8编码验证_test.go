package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestValidUtf8(t *testing.T) {
	//println(problems.ValidUtf8([]int{197, 130, 1}))
	//println(problems.ValidUtf8([]int{235, 140, 4}))
	println(problems.ValidUtf8([]int{8, 21, 212, 177, 245, 187, 178, 157, 18, 196, 155, 227, 164, 170, 5, 196, 144, 229, 187, 161, 235, 164, 188, 12, 198, 163, 245, 135, 188, 189, 113, 77, 202, 177, 213, 166, 237, 129, 180, 247, 174, 169, 167, 217, 142, 228, 154, 184, 245, 163, 146, 157, 107, 225, 182, 180, 243, 149, 146, 153, 210, 158, 30, 201, 167, 227, 160, 160}))
	fmt.Printf("%b", 230)
}
