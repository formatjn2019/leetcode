package problems

import "fmt"

func KSimilarity(s1 string, s2 string) int {
	return kSimilarity(s1, s2)
}

func kSimilarity(s1 string, s2 string) int {
	if s1 == s2 {
		return 0
	}
	i1, i2 := int64(0), int64(0)
	lenth := len(s1)
	for i := 0; i < lenth; i++ {
		i1 <<= 3
		i2 <<= 3
		i1 |= int64(s1[lenth-i-1] - 'a' + 1)
		i2 |= int64(s2[lenth-i-1] - 'a' + 1)
	}
	fmt.Printf("%60b\n%60b\n", i1, i2)

	// var swap func(int, int, int64) int64
	swap := func(index, index2 int, num int64) int64 {
		ln := int64((num >> ((lenth - index - 1) * 3)) % 8)
		rn := int64((num >> ((lenth - index2 - 1) * 3)) % 8)
		return num ^ (ln << ((lenth - index - 1) * 3)) ^ (rn << ((lenth - index2 - 1) * 3)) | (ln << ((lenth - index2 - 1) * 3)) | (rn << ((lenth - index - 1) * 3))
	}
	usedNum := map[int64]bool{i1: true}
	levelMap := map[int64]bool{i1: true}
	count := 0
outter:
	for {
		nextLevel := map[int64]bool{}
		count++
		for num, _ := range levelMap {
			for i := 0; i < lenth; i++ {
				if (num>>(3*(lenth-i-1)))%8 == (i2>>(3*(lenth-i-1)))%8 {
					continue
				}
				for j := i + 1; j < lenth; j++ {
					//剪枝，已经定位的字符不再进行交换
					if (num>>(3*(lenth-j-1)))%8 == (i2>>(3*(lenth-j-1)))%8 {
						continue
					}

					nNum := swap(i, j, num)
					if nNum == i2 {
						break outter
					}
					if !usedNum[nNum] {
						nextLevel[nNum] = true
						usedNum[nNum] = true
					}
				}
			}
		}
		levelMap = nextLevel
	}
	fmt.Println(count)
	return count
}
