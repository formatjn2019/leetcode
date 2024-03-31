package problems

func capitalizeTitle(title string) string {
	dif := func(x rune) rune {
		if x >= 'a' {
			return x - 'a'
		}
		return x - 'A'
	}
	arr := []rune(title)
	for lp, rp := 0, 0; lp < len(arr); lp = rp {
		//快指针前移
		for rp < len(arr) && arr[rp] != ' ' {
			rp++
		}
		// 慢指针位移
		if rp-lp < 3 {
			for ; lp < rp; lp++ {
				arr[lp] = dif(arr[lp]) + 'a'
			}
		} else {
			arr[lp] = dif(arr[lp]) + 'A'
			for lp = lp + 1; lp < rp; lp++ {
				arr[lp] = dif(arr[lp]) + 'a'
			}
		}
		//快指针前移
		for rp < len(arr) && arr[rp] == ' ' {
			rp++
		}
	}
	return string(arr)
}
