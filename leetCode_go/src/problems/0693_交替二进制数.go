package problems

func hasAlternatingBits(n int) bool {
	switch n%4 {
	case 1:
		for ;n>0;n/=4 {
			if (n%4)^1!=0 {
				return false
			}
		}
		return true
	case 2:
		for ;n>0;n/=4 {
			if (n%4)^2!=0 {
				return false
			}
		}
		return true
	}
	return false
}