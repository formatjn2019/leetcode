package problems

import (
	"strconv"
	"strings"
)
func LargestNumber(nums []int) string {
	return largestNumber(nums)
}

func largestNumber(nums []int) string {
	lenth:=len(nums)
	tempArr:=make([]string,0,lenth)
	for _,num:=range nums{
		tempArr = append(tempArr, strconv.Itoa(num))
	}
	for i:=0;i<lenth;i++ {
		for j:=i+1;j<lenth;j++ {
			//交换
			if judge(tempArr[i],tempArr[j]) {
				tempArr[i],tempArr[j]=tempArr[j],tempArr[i]

			}
		}
	}
	result:=strings.Builder{}
	for _,str:=range tempArr{
		result.WriteString(str)
	}
	resultStr:= result.String()
	if resultStr[0]=='0' {
		return "0"
	}
	return resultStr
}

func judge(str1,str2 string) bool {
	l1,l2:=len(str1),len(str2)
	lenth:=l1+l2
	for i:=0;i<lenth;i++ {
		if str1[i%l1]<str2[i%l2] {
			return true
		}else if str1[i%l1]>str2[i%l2]  {
			return false
		}
	}
	return false
}


