package problems

import (
	"fmt"
)

func Rotate(nums []int, k int)  {
	rotate(nums,k)
	fmt.Println(nums)
}
func rotate(nums []int, k int)  {
	lenth:=len(nums)
	count:=0
	for start:=0;count<lenth;start++ {
		//原地交换
		temp,ti:=nums[start],start
		for {
			ni:=(ti+k)%lenth
			temp,ti,nums[ni]=nums[ni],ni,temp
			count++
			if ni==start {
				break
			}
		}
	}
}