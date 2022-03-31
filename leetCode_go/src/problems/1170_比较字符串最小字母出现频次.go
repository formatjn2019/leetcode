package problems

import "sort"


func NumSmallerByFrequency(queries []string, words []string) []int {
	return numSmallerByFrequency(queries,words)
}

func numSmallerByFrequency(queries []string, words []string) []int {
	judgeArr:=make([]int,0)
	for _,str:=range words{
		judgeArr = append(judgeArr, f(str))
	}
	sort.Ints(judgeArr)
	result:=make([]int,len(queries))
	for i,queriy:=range queries{
		num:=f(queriy)
		index:=len(words)
		//二分查找
		for lp,rp:=0,len(judgeArr);lp<rp;{
			mid:=(lp+rp)/2
			switch  {
			case judgeArr[mid]>num:
				rp=mid
				index=mid
			case judgeArr[mid]<=num:
				lp=mid+1
			}
		}

		result[i]=len(words)-index
	}
	return result
}

func f(str string)int  {
	result:=0
	searchChar:='z'+1
	for _,c:=range str{
		if searchChar==c {
			result++
		}else if searchChar>c {
			searchChar=c
			result=1
		}
	}
	return result
}