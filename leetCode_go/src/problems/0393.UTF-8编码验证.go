package problems

func ValidUtf8(data []int) bool {
	return validUtf8(data)
}

func validUtf8(data []int) bool {
	lenth := len(data)
	for i := 0; i < lenth; i++ {
		//判定首位
		n := data[i]
		switch {
		case n < 128:
			continue
		case n>>5 == 6:
			if i > lenth-2 || data[i+1]>>6 != 2 {
				return false
			}
			i += 1
		case n>>4 == 14:
			if i > lenth-3 || data[i+1]>>6 != 2 || data[i+2]>>6 != 2 {
				return false
			}
			i += 2
		case n>>3 == 30:
			if i > lenth-3 || data[i+1]>>6 != 2 || data[i+2]>>6 != 2 || data[i+3]>>6 != 2 {
				return false
			}
			i += 3
		default:
			return false

		}
	}

	return true
}
