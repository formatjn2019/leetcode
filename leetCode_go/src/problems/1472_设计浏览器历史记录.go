package problems

type BrowserHistory struct {
	point int
	urls  []string
}

func BrowserHistoryConstructor(homepage string) BrowserHistory {
	return BrowserHistory{point: 0, urls: []string{homepage}}
}

func (this *BrowserHistory) Visit(url string) {
	this.urls = append(this.urls[:this.point+1], url)
	this.point += 1
}

func (this *BrowserHistory) Back(steps int) string {
	this.point = this.point - steps
	if this.point < 0 {
		this.point = 0
	}
	return this.urls[this.point]
}

func (this *BrowserHistory) Forward(steps int) string {
	this.point = this.point + steps
	if this.point >= len(this.urls) {
		this.point = len(this.urls) - 1
	}
	return this.urls[this.point]
}
