package main

import "fmt"

func main() {
	var w, h float32

	fmt.Scan(&w, &h)

	fmt.Printf("%.1f", w*h/2)
}
