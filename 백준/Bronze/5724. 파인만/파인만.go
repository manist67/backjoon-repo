package main

import "fmt"

func main() {
	for {
		var n int
		fmt.Scanf("%d\n", &n)
		if n == 0 {
			return
		}

		ans := 0
		for i := 1; i <= n; i++ {
			ans += i * i
		}

		fmt.Printf("%d\n", ans)
	}
}
