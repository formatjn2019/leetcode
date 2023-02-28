package test

import (
	"src/problems"
	"src/tools"
	"testing"
)

func TestMergeSimilarItems(t *testing.T) {
	problems.MergeSimilarItems(tools.ParseArr("[[1,1],[4,5],[3,8]]"), tools.ParseArr(" [[3,1],[1,5]]"))
	problems.MergeSimilarItems(tools.ParseArr("[[1,1],[3,2],[2,3]]"), tools.ParseArr("[[2,1],[3,2],[1,3]]"))
	problems.MergeSimilarItems(tools.ParseArr("[[1,3],[2,2]]"), tools.ParseArr("[[7,1],[2,2],[1,4]]"))
}
