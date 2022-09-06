package test

import (
	"fmt"
	"src/problems"
	"testing"
)

func TestUniqueLetterString(t *testing.T) {
	fmt.Printf("problems.UniqueLetterString(\"ABC\"): %v\n", problems.UniqueLetterString("ABC"))
	fmt.Printf("problems.UniqueLetterString(\"ABA\"): %v\n", problems.UniqueLetterString("ABA"))
	fmt.Printf("problems.UniqueLetterString(\"LEETCODE\"): %v\n", problems.UniqueLetterString("LEETCODE"))
	fmt.Printf("problems.UniqueLetterString(\"IECIYJSQHMDHQPCOTCQTVYEQMEYGGVPBUPKVHAAGBQKAQQVMWTMZZSEGTYWTBCNOWPWIBFDGVPHJYBMXFGSEQHNYAOHCPRJGARZA\"): %v\n", problems.UniqueLetterString("IECIYJSQHMDHQPCOTCQTVYEQMEYGGVPBUPKVHAAGBQKAQQVMWTMZZSEGTYWTBCNOWPWIBFDGVPHJYBMXFGSEQHNYAOHCPRJGARZA"))
}
