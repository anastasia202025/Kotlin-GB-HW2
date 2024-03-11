import com.sun.jdi.Value
//1.Дописать классы
//Написать реализацию класса Holder и интерфейса
//ValueChangeListener,таких, чтобы программа компилировалась , и при
//выполнении функции main на экран было выведено "New value is 1".
//interface ValueChangeListener{
//fun onNewValue(number: Int)
//}
//class Holder private constructor( number: Int) {
//    var listener:ValueChangeListener? = null
//    var number: Int = number
//        set(value) {
//            listener?.onNewValue(number)
//            field = value
//        }
//
//    //var listener:ValueChangeListener? = null
//    companion object {
//        const val DEFAULT_NUMBER = -1
//        fun createHolder(number: Int)=Holder(number )
//            //return Holder(defaultNumber)
//    }
//}
//
//
//fun main() {
//    val holder = Holder.createHolder(Holder.DEFAULT_NUMBER)
//    holder.number = 9
//    holder.listener = object : ValueChangeListener {
//        override fun onNewValue(number: Int) {
//            println("New value is $number")
//        }
//    }
//
//     holder.number = 1
//
//}


interface ValueChangeListener {
    fun onNewValue(number: Int)
}

class Holder private constructor(number: Int) {

    var number: Int = number
        set(value) {
            field = value
            listener?.onNewValue(value)
        }

    var listener: ValueChangeListener? = null

    companion object {
        const val DEFAULT_NUMBER = -1
        fun createHolder(defaultNumber: Int): Holder {
            return Holder(defaultNumber)
        }
    }
}


fun main() {
    val holder = Holder.createHolder(Holder.DEFAULT_NUMBER)
    holder.number = 9
    holder.listener = object : ValueChangeListener {
        override fun onNewValue(number: Int) {
            println("New value is $number")
        }
    }
    holder.number = 1
}
