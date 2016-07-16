import java.util.*

/**
 * Created by sofysmo on 16.07.16.
 */

fun toJSON(collection: Collection<Int>): String{

    println("gg")
    val sb:StringBuilder=StringBuilder()
    sb.append("[")
    val iterator:Iterator< Int> = collection.iterator()
    while(iterator.hasNext())
    {
        val element:Int=iterator.next()
        sb.append(element)
        if(iterator.hasNext()) sb.append(", ")
    }
    sb.append("]")
    return sb.toString()
}
fun containsEven(collection: Collection<Int>): Boolean = collection.any { it%2==0 }
data class Person(val name:String, val age:Int)

fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
}
fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
){
    val personalInfo:PersonalInfo? = client?.personalInfo
    val email:String? = personalInfo?.email
    if(email!=null && message!=null) mailer.sendMessage(email, message);
}

data class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)
interface Mailer {
    fun sendMessage(email: String, message: String)
}

fun eval(expr: Expr): Int =
        when (expr) {
            is Num -> (expr as Num).value
            is Sum -> {
                val sum=expr as Sum
                eval(sum.left) + eval(sum.right)
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun Int.r(): RationalNumber = RationalNumber(this, 0)
fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(this.first,this.second)
data class RationalNumber(val numerator: Int, val denominator: Int)


fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object: Comparator<Int>{
        override fun compare(o1: Int,o2:Int ): Int
        {
            return o2.compareTo(o1)
        }
    })
    return arrayList
}
fun main(args : Array<String>){
    print(getList())
    //val i:MutableList<Int> = mutableListOf(1, 2, 3)
    //print(containsEven(i))//toJSON(i))
}