interface Action {
    fun cancelAction(ls: MutableList<Int>)
}

class AddFrontAction(elem: Int, ls: MutableList<Int>) : Action {
    init {
        ls.add(0, elem)
    }
    override fun cancelAction(ls: MutableList<Int>) = ls.removeFirst().let {}
}

class AddBackAction(elem: Int, ls: MutableList<Int>) : Action {
    init { ls.add(ls.size, elem) }
    override fun cancelAction(ls: MutableList<Int>) = ls.removeLast().let {}
}

class SwapAction(private val i: Int, private val j: Int, ls: MutableList<Int>) : Action {
    init {
        val validRange = 0..ls.lastIndex
        if (i !in validRange || j !in validRange) {
            // throw Exception("Invalid range for SwapAction")
            println("Incorrect indexes for SwapAction: $i, $j. Available range: $validRange")
        } else {
            ls.add(j, ls.removeAt(i))
        }
    }
    override fun cancelAction(ls: MutableList<Int>) {
        ls.add(i, ls.removeAt(j))
    }
}

class PerformedCommandStorage(private val ls: MutableList<Int>) {
    private val data = emptyList<Action>().toMutableList()
    fun storeAction(act: Action) = data.add(act)
    fun cancelAction() = if (data.isEmpty()) println("No actions in the storage, nothing to cancel")
        else data.removeAt(data.lastIndex).cancelAction(ls)
}

/* test
fun main(){
    val l = (0..3).toMutableList()
    val log = PerformedCommandStorage(l)
    log.storeAction(AddBackAction(100, l))
    println(l)
    log.storeAction(AddFrontAction(-100, l))
    println(l)
    log.storeAction(SwapAction(0, l.lastIndex, l))
    println(l)
    log.cancelAction()
    println(l)
    log.cancelAction()
    println(l)
    log.cancelAction()
    println(l)
}
 */
