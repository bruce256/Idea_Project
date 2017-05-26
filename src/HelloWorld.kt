/**
 *
 * @author 儒尊
 * @date 2017/05/20
 */

fun main(args: Array<String>) {
    println("hello world")
    println(add(3, 5))
    println(value())
    println("lvsheng".toUpperYZL())
}

fun add(a: Int, b: Int) = a + b

fun value(): Int {
    val a: Int = 10
    return a
}

fun String.toUpperYZL() : String= this.toUpperCase() + "-YZL"