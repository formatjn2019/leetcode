package problems

func subarraysDivByK_timeout (nums []int, k int) int {
	result,lenth:=0,len(nums)
	for i:=0;i<lenth;i++{
		sum:=0
		for j:=i;j<lenth;j++ {
			sum+=nums[j]
			if sum%k==0 {
				result++
			}
		}
	}
	return result
}