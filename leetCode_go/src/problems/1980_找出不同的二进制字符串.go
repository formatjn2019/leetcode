package problems

import (
	"strconv"
)



func FindDifferentBinaryString(nums []string) string {
	return findDifferentBinaryString(nums)
}

func findDifferentBinaryString(nums []string) string {
	used:=make([]bool,len(nums)+1)
	for _,str:=range nums{
		n,_:=strconv.ParseInt(str,2,32)
		nn:=int(n)
		if nn<len(used) {
			used[nn]=true
		}
	}
	for i,use:=range used{
		if !use {
			return convToBinary(i,len(nums))
		}
	}
	return ""
}

func convToBinary(num ,size int)string{
	arr:=make([]rune,size)
	for ;size>0;size-- {
		arr[size-1]=rune(num%2)+'0'
		num/=2
	}
	return string(arr)
}