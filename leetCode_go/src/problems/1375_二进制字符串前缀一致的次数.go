package problems

func NumTimesAllBlue(flips []int) int {
	return numTimesAllBlue(flips)
}


func numTimesAllBlue(flips []int) int {
	result,n:=0,len(flips)
	prefixSumArr:=make([]int,n)
	sum:=0
	for i,idx:=range flips{
		prefixSumArr[idx-1]++
		sum+=prefixSumArr[i]
		if idx-1<i{
			sum++
		}
		if sum == i+1{
			result++
		}
	}
	return result
}