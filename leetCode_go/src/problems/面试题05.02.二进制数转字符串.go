package problems

import "bytes"

func PrintBin(num float64) string {
	return printBin(num)
}
func printBin(num float64) string {
	var bf bytes.Buffer
	bf.WriteByte('0')
	bf.WriteByte('.')
	for bf.Len() < 34 && num != 0 {
		num *= 2
		if num >= 1 {
			num -= 1
			bf.WriteByte('1')
		} else {
			bf.WriteByte('0')
		}
	}
	if bf.Len() > 32 {
		return "ERROR"
	}
	return bf.String()
}
