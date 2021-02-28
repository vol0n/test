fun factorialRec(n: Int): Int
    = if (n <= 1) 1 else n*factorialRec(n-1)


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
        if (scan.hasNextInt()){
            val n = scan.nextInt()
            if (n < 0){
                println("Only non-negative integers are allowed.")
                continue
            }
            println("Enter 1 to use recursive method and 2 to use the iterative one: ")
            when (scan.next()){
                "1" -> {println("Result: ${factorialRec(n)}")}
                "2" -> {println("Result: ${factorialIter(n)}")}
                "q" -> {break}
                else -> {println("Unknown option.")}
            }
        }
        else {
            val buf = scan.next()
            if (buf == "q") break
            else println("Unknown command.")
        }
    }
}
