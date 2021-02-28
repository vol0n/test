fun countOccurrences(where: String, what: String): Int =
    where.substring(0, where.length - what.length + 1)
    .mapIndexed { idx, _ -> if (where.substring(idx, idx + what.length) == what) 1 else 0 }
    .reduce { sum, x -> sum + x }

fun main() {
    val scan = java.util.Scanner(System.`in`)
    println("Enter the string in which to search: ")
    val str1 = scan.nextLine()
    println("Enter the substring to find: ")
    val str2 = scan.nextLine()
    println(countOccurrences(str1, str2))
}
