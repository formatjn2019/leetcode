package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestMaxAverageRatio(t *testing.T) {
	fmt.Printf("problems.MaxAverageRatio(tools.ParseArr(\"[[1,2],[3,5],[2,2]]\"), 2): %v\n", problems.MaxAverageRatio(tools.ParseArr("[[1,2],[3,5],[2,2]]"), 2))
	fmt.Printf("problems.MaxAverageRatio(tools.ParseArr(\"[[2,4],[3,9],[4,5],[2,10]]\"), 4): %v\n", problems.MaxAverageRatio(tools.ParseArr("[[2,4],[3,9],[4,5],[2,10]]"), 4))
}
