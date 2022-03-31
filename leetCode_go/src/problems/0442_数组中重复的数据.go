package problems

func FindDuplicates(nums []int) []int {
	return findDuplicates(nums)
}
func findDuplicates(nums []int) []int {
	for start:=range nums{
		//fmt.Println(nums)
		if nums[start]>0 && nums[start]!=start+1 {
			//当前坐标，当前数值
			num,index:=nums[start],start
			nums[start]=0

			for num-1!=index && num>0 {
				nindex:=num-1
				if nums[nindex] ==num {
					nums[nindex]=-1
					break
				}else if nindex>=0 {
					num,index,nums[nindex]=nums[nindex],nindex,num
				}

			}
		}

	}
	result:=make([]int,0)
	for i,num:=range nums{
		if num==-1 {
			result = append(result, i+1)
		}
	}
	return result
}