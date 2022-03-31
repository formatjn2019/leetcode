package problems

func NumTriplets(nums1 []int, nums2 []int) int {
	return numTriplets(nums1,nums2)
}
func numTriplets(nums1 []int, nums2 []int) int {
	hashTab1,hashTab2:=map[int64]int{},map[int64]int{}
	for _,num:=range nums1{
		pre,_:=hashTab1[int64(num*num)]
		hashTab1[int64(num*num)]=pre+1
	}
	for _,num:=range nums2{
		pre,_:=hashTab2[int64(num*num)]
		hashTab2[int64(num*num)]=pre+1
	}
	result:=0
	result+=count(nums1,hashTab2)
	result+=count(nums2,hashTab1)
	return result
}
func count(nums []int,hashTab map[int64]int) (result int) {
	//fmt.Println(hashTab)
	//fmt.Println(nums)
	//arr判定
	lenth:=len(nums)
	for i:=0;i<lenth;i++{
		for j:=i+1;j<lenth;j++{
			if count,ok:=hashTab[int64(nums[i]*nums[j])];ok {
				result+=count
			}
		}
	}
	//println(result)
	return result
}