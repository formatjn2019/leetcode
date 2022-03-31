package test

import (
	"src/problems"
	"testing"
)

func TestMaxConsecutiveAnswers(t *testing.T){
	println(problems.MaxConsecutiveAnswers("TTFF", 2))
	println(problems.MaxConsecutiveAnswers("TFFT", 1))
	println(problems.MaxConsecutiveAnswers("TTFTTFTT", 1))
}
