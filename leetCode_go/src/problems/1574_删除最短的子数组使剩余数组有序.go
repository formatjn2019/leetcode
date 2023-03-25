package problems

func FindLengthOfShortestSubarray(arr []int) int {
	return findLengthOfShortestSubarray(arr)
}
func findLengthOfShortestSubarray(arr []int) int {
	n := len(arr)
	la, ra := arr[:1], arr[n-1:]
	//寻找头尾最长数组
	for i := 1; i < n; i++ {
		if arr[i-1] <= arr[i] {
			la = arr[:i+1]
		} else {
			break
		}
	}
	for j := n - 2; j >= 0; j-- {
		if arr[j] <= arr[j+1] {
			ra = arr[j:]
		} else {
			break
		}
	}
	if len(la) == n {
		return 0
	}
	maxLenth := len(la)
	if len(ra) > maxLenth {
		maxLenth = len(ra)
	}
	//左右数组拼接
	for ri, rn := range ra {
		for li := len(la) - 1; li >= 0 && maxLenth < (len(ra)-ri+li+1); li-- {
			if ln := la[li]; rn >= ln {
				maxLenth = len(ra) - ri + li + 1
			}
		}
	}
	return n - maxLenth
}
