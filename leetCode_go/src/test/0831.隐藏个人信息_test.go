package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestMaskPII(t *testing.T) {
	dataArr := []string{
		"LeetCode@LeetCode.com",
		"AB@qq.com",
		"1(234)567-890",
		"86-(10)12345678",
	}
	for _, str := range dataArr {
		fmt.Println(str, problems.MaskPII(str))
	}
}
