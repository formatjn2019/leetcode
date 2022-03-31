package problems

func MaxRepOpt1(text string) int {
	return maxRepOpt1(text)
}

func maxRepOpt1(text string) int {
	cCount:=[26]int{}
	judge:=make([][2]int,1)
	for _,c:=range text{
		cCount[c-'a']++
		if judge[len(judge)-1][0]!=int(c) {
			judge = append(judge, [2]int{int(c),1})
		}else {
			judge[len(judge)-1][1]++
		}
	}
	judge = append(judge, [2]int{})
	result:=0
	for i:=1;i<len(judge)-1;i++ {
		temp:=judge[i][1]
		//判定移动单个字符
		if temp<cCount[judge[i][0]-97] {
			temp++
		}
		if temp >result {
			result=temp
		}
		//如果两端字符可合并
		if judge[i-1][0]==judge[i+1][0] && judge[i][1]==1{
			exp:=judge[i-1][1]+judge[i+1][1]
			if cCount[judge[i-1][0]-97]>exp {
				exp++
			}
			if exp>result {
				result=exp
			}
		}
	}


	//fmt.Println(judge)
	//fmt.Println(cCount)
	//fmt.Println(result)
	return result
}