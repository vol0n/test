fun factorialRec(n: Int): Int = if (n <= 1) 1 else n * factorialRec(n - 1)

fun factorialIter(n: Int): Int {
    var res = n
    for (i in 2 until n) {
        res *= i
    }
    return res
}

val scan = java.util.Scanner(System.`in`)

fun main() {
    println("To quit enter: 'q'")
    while (true) {
        println("Enter a natural number to compute factorial: ")
        if (scan.hasNextInt()) {
            val n = scan.nextInt()
            if (n < 0) {
                println("Only non-negative integers are allowed.")
            } else {
                println("The result is: ${factorialIter(n)}")
            }
        } else {
            val buf = scan.next()
            if (buf == "q") break
            else println("Unknown input.")
        }
    }
}
