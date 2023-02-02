package test

import (
	"fmt"
	"src/problems"
	"src/tools"
	"testing"
)

func TestShortestAlternatingPaths(t *testing.T) {
	fmt.Printf("problems.ShortestAlternatingPaths(3, tools.ParseArr(\"[[0,1],[1,2]]\"), tools.ParseArr(\"[]\")): %v\n", problems.ShortestAlternatingPaths(3, tools.ParseArr("[[0,1],[1,2]]"), tools.ParseArr("[]")))
	fmt.Printf("problems.ShortestAlternatingPaths(3, tools.ParseArr(\"[[0,1]]\"), tools.ParseArr(\"[[2,1]]\")): %v\n", problems.ShortestAlternatingPaths(3, tools.ParseArr("[[0,1]]"), tools.ParseArr("[[2,1]]")))
	fmt.Printf("problems.ShortestAlternatingPaths(3, tools.ParseArr(\"[[1,0]]\"), tools.ParseArr(\"[[2,1]]\")): %v\n", problems.ShortestAlternatingPaths(3, tools.ParseArr("[[1,0]]"), tools.ParseArr("[[2,1]]")))
	fmt.Printf("problems.ShortestAlternatingPaths(3, tools.ParseArr(\"[[0,1]]\"), tools.ParseArr(\"[[1,2]]\")): %v\n", problems.ShortestAlternatingPaths(3, tools.ParseArr("[[0,1]]"), tools.ParseArr("[[1,2]]")))
	fmt.Printf("problems.ShortestAlternatingPaths(3, tools.ParseArr(\"[[0,1],[0,2]]\"), tools.ParseArr(\"[[1,0]]\")): %v\n", problems.ShortestAlternatingPaths(3, tools.ParseArr("[[0,1],[0,2]]"), tools.ParseArr("[[1,0]]")))
	fmt.Printf("problems.ShortestAlternatingPaths(5, tools.ParseArr(\"[[0,1],[1,2],[2,3],[3,4]]\"), tools.ParseArr(\"[[1,2],[2,3],[3,1]]\")): %v\n", problems.ShortestAlternatingPaths(5, tools.ParseArr("[[0,1],[1,2],[2,3],[3,4]]"), tools.ParseArr("[[1,2],[2,3],[3,1]]")))
	fmt.Printf("problems.ShortestAlternatingPaths(5, tools.ParseArr(\"[[3,2],[4,1],[1,4],[2,4]]\"), tools.ParseArr(\"[[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]\")): %v\n", problems.ShortestAlternatingPaths(5, tools.ParseArr("[[3,2],[4,1],[1,4],[2,4]]"), tools.ParseArr("[[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]")))
}
