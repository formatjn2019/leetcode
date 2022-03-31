package problems

import "strconv"

func CalPoints(ops []string) int {
	return calPoints(ops)
}

func calPoints(ops []string) int {
	scores:=make([]int,0)
	for _,str:=range ops{
		switch str {
		case "C":
			scores=scores[0:len(scores)-1]
		case "D":
			scores = append(scores, scores[len(scores)-1]*2)
		case "+":
			scores = append(scores, scores[len(scores)-1]+scores[len(scores)-2])
		default:
			num,_ := strconv.Atoi(str)
			scores = append(scores,num)
		}
	}
	result:=0
	for _,num:=range scores{
		result+=num
	}
	return result
}
