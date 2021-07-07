package com.example.runoobkotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.reflect.KProperty
import kotlin.properties.Delegates

fun lambda_匿名函数() {
    val sumLambda: (Int, Int) -> Int = {x,y -> x+y}
    println(sumLambda(1,2))  // 输出 3
}

fun For_循环() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun while_与_doWhile_循环() {
    println("----while 使用-----")
    var x = 5
    while (x > 0) {
        println( x--)
    }
    println("----do...while 使用-----")
    var y = 5
    do {
        println(y--)
    } while(y>0)
}

class Person {

    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = 145.4f
        private set
}

// 测试
fun getter_和_setter() {
    var person: Person = Person()


    //初始化时
    println("lastName:${person.lastName}")
    println("no:${person.no}")

    //后来改动变量
    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

}

class Runoob(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun 构造函数init() {
    val runoob =  Runoob("菜鸟教程")
    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}


class Runoob2(name: String) {
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }
    // 次构造函数
    constructor (name: String, alexa: Int) : this(name) {
        println("Alexa 排名 $alexa")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun 次构造函数() {
    val runoob =  Runoob2("菜鸟教程", 10000)
    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}

class Outer {
    private val bar: Int = 1
    var v = "成员属性"
    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest():String {
            var o = this@Outer //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
            return "ok"
        }
    }

    class Test{
        fun fun1(){
            println("ok")
        }
    }

}

fun 内部类() {
    val demo = Outer().Inner().foo()
    println(demo) //   1

    val demo2 = Outer().Inner().innerTest()
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性



}

//例子：匿名内部类
class Test {
    var v = "成员属性"

    fun setInterFace(obj1: TestInterFace) {
        obj1.func1()
    }
}

/**
 * 定义接口
 */
interface TestInterFace {
    fun func1()
}

fun 匿名内部类() {
    var pTest = Test()

    /**
     * 采用对象表达式来创建接口对象，即匿名内部类的实例。
     */
    pTest.setInterFace(object : TestInterFace {
        override fun func1() {
            println("对象表达式创建匿名内部类的实例")
        }
    })


    var pTest2 = Test()
    pTest2.setInterFace(object : TestInterFace {
        override fun func1() {
            println("123")
        }
    })
}

//例子：实现接口
interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child : MyInterface {
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun 实现接口() {
    val c =  Child()
    c.foo();
    c.bar();

}

//例子：接口中的属性
interface MyInterface2 {
    var name:String //name 属性, 抽象的
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child2 : MyInterface2 {
    override var name: String = "runoob" //重写属性
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun 接口中的属性() {
    val c =  Child2()
    c.foo();
    c.bar();
    println(c.name)

}

//例子：函数重写
interface A {
    fun foo() { println("A foo") }   // 已实现
    fun bar() // 未实现，没有方法体，是抽象的
}

interface B {
    fun foo() { println("B foo") }   // 已实现
    fun bar() { println("B bar") } // 已实现
}

class C : A {
    override fun bar() { println("C bar") }   // 重写
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}

fun 函数重写() {
    println("函数重写")
    val d =  D()
    d.foo()
    d.bar()
}

//例子：扩展函数
class User(var name:String)

/**扩展函数**/
fun User.Print(){
    println("用户名 $name")
}

fun 扩展函数(){
    var user = User("Runoob")
    user.Print()
}


//例子：扩展函数swap,调换不同位置的值
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]     //  this 对应该列表
    this[index1] = this[index2]
    this[index2] = tmp
}

fun 扩展函数swap() {

    val l = mutableListOf(1, 2, 3)
    // 位置 0 和 2 的值做了互换
    l.swap(0, 2) // 'swap()' 函数内的 'this' 将指向 'l' 的值

    println(l.toString())
}

//教程：静态类的使用 https://www.programmersought.com/article/89484574055/
object Constants1 {
    val text = "静态类的使用"
}

fun 静态类的使用(){
    println(Constants1.text)
}

//教程：静态函数的使用 https://www.programmersought.com/article/89484574055/
class Constants {
    companion object {
        val text = "类中的静态变量"

        fun b() {
            println("类中的静态函数")
        }
    }
}

fun 静态函数的使用(){
    println(Constants.text)
    println(Constants.b())
}



//教程：扩展函数是静态解析的
open class C1

class D1: C1()

fun C1.foo() = "c"   // 扩展函数 foo

fun D1.foo() = "d"   // 扩展函数 foo

fun printFoo(c: C1) {
    println(c.foo())  // 类型是 C 类
}

fun 扩展函数是静态解析的(){
    printFoo(D1())
}

/**
 * 教程：扩展一个空对象
在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数。例如:
 **/
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}
fun 扩展一个空对象(){
    var t = null
    println(t.toString())
}


/**教程：扩展声明为成员
在一个类内部你可以为另一个类声明扩展。

在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
 */

class D3 {
    fun bar() { println("D bar") }
}

class C3 {
    fun baz() { println("C baz") }

    fun D3.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz
    }
    fun D3.test() {
        println("C3 D3.test")
    }

    fun caller(调用扩展: D3) {
        调用扩展.foo()   // 调用扩展函数
        调用扩展.test()
    }
}

fun 扩展声明为成员() {
    val c3: C3 = C3()
    val d3: D3 = D3()
    c3.caller(d3)

}

/**
 * 教程：数据类
Kotlin 可以创建一个只包含数据的类，关键字为 data：

 */

data class User3(var name: String, var age: Int)


fun 数据类() {
    val jack = User3(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    olderJack.age = 3
    println(jack)
    println(olderJack)

}

/**
 * 教程：Kotlin 泛型
泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上。
与 Java 一样，Kotlin 也提供泛型，为类型安全提供保证，消除类型强转的烦恼。
 */

class Box<T>(t : T) {
    var value = t
}

fun Kotlin泛型() {
    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Runoob")

    println(boxInt.value)
    println(boxString.value)
}

/**
 * 教程：泛型函数
 * 在调用泛型函数时，如果可以推断出类型参数，可以省略泛型参数。

以下实例创建了泛型函数 doPrintln，函数根据传入的不同类型做相应处理：
 */


fun <T> doPrintln(content: T) {

    when (content) {
        is Int -> println("整型数字为 $content")
        is String -> println("字符串转换为大写：${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

fun 泛型函数() {
    val age = 23
    val name = "runoob"
    val bool = true

    doPrintln(age)    // 整型
    doPrintln(name)   // 字符串
    doPrintln(bool)   // 布尔型
}

/**
 *教程：支持协变的类
声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型：
 */
// 定义一个支持协变的类
class Runoob1<out A>(val a: A) {
    fun foo(): A {
        return a
    }
}

fun 支持协变的类() {
    var strCo: Runoob1<String> = Runoob1("a")
    var anyCo: Runoob1<Any> = Runoob1<Any>("b")
    anyCo = strCo
    println(anyCo.foo())   // 输出 a
}



/**
 * 教程：支持逆变的类
 * in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型：
 */
class Runoob3<in A>(a: A) {
    fun foo(a: A) {
    }

}

fun 支持逆变的类() {
    var strDCo = Runoob3("a")
    var anyDCo = Runoob3<Any>("b")
    strDCo = anyDCo
    println(strDCo.foo("c"))
}

/**
 * 教程：使用枚举常量
 */

enum class Color(value:String){
    RED("red"),
    BLACK("black"),
    BLUE("blue"),
    GREEN("green"),
    WHITE("white")
}

fun 使用枚举常量() {
    var mColor:Color=Color.BLUE

    println("values:" + Color.values())
    println("valueOf:" + Color.valueOf("RED"))
    println("name:" + mColor.name)
    println("mColor:" + mColor)
    println("ordinal:" + mColor.ordinal)

}

/**
 * 教程：object对象声明
Kotlin 使用 object 关键字来声明一个对象。

Kotlin 中我们可以方便的通过对象声明来获得一个单例。
 */

object Site {
    var url:String = ""
    val name: String = "菜鸟教程"
}
fun object对象声明() {
    var s1 =  Site
    var s2 = Site
    s1.url = "www.runoob.com"
    println(s1.url)
    println(s2.url)
}

/**
 * 教程：object对象声明2
Kotlin 使用 object 关键字来声明一个对象。

Kotlin 中我们可以方便的通过对象声明来获得一个单例。
 */
class Site4 {
    var name = "菜鸟教程"
    object DeskTop{
        var url = "www.runoob.com"
        fun showName(){
            //print{"desk legs $name"} // 错误，不能访问到外部类的方法和变量
        }
    }
}
fun object对象声明2() {
    var mSite4 = Site4()
    //println(mSite4.DeskTop.url) // 错误，不能通过外部类的实例访问到该对象
    println(Site4.DeskTop.url) // 正确
}

/**
 * 教程：伴生对象
类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素。
 */

class ObjectTest {

    companion object MyObjec{

        val a = 20

        fun method() {
            println("I'm in companion object")
        }
    }
}

fun 伴生对象(){
    ObjectTest.MyObjec.method()
    println(ObjectTest.MyObjec.a)
}

/**
 * 教程：类委托
类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。
以下实例中派生类 Derived 继承了接口 Base 所有方法，并且委托一个传入的 Base 类的对象来执行这些方法。
 */

// 创建接口
interface Base {
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() { println(x) }
}

// 通过关键字 by 建立委托类
class Derived(b: Base) : Base by b

fun 类委托() {
    val mBaseImpl = BaseImpl(10)
    Derived(mBaseImpl).print() // 输出 10
}

/**
 * 教程：定义包含属性委托的类
该类需要包含 getValue() 方法和 setValue() 方法，且参数 thisRef 为进行委托的类的对象，prop 为进行委托的属性的对象。
 */
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}
fun 定义包含属性委托的类() {
    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数

    e.p = "Runoob"   // 调用 setValue() 函数
    println(e.p)
}

/**
 * 教程：可观察属性 Observable
observable 可以用于实现观察者模式。

Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)。

在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值：
 */


class UserObservable {
    var name: String by Delegates.observable("初始值") {
        property,
        oldValue,
        newValue ->
        println("property:$property -> 旧值：$oldValue -> 新值：$newValue")
    }
}

fun 可观察属性Observable() {
    val user = UserObservable()
    user.name = "第一次赋值"
    user.name = "第二次赋值"
}

/**
 * 教程：把属性储存在映射中
一个常见的用例是在一个映射（map）里存储属性的值。 这经常出现在像解析 JSON 或者做其他"动态"事情的应用中。 在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
 */
class 映射中Site(val mMap: Map<String, Any?>) {
    val name: String by mMap
    val url: String  by mMap
}

fun 把属性储存在映射中() {
    // 构造函数接受一个映射参数
    val site = 映射中Site(mapOf(
        "name" to "菜鸟教程",
        "url"  to "www.runoob.com"
    ))


    // 读取映射值
    println(site.name)
    println(site.url)
}

/**
 * 教程：把属性储存在映射中
一个常见的用例是在一个映射（map）里存储属性的值。
这经常出现在像解析 JSON 或者做其他"动态"事情的应用中。
在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
 */
class SiteMutableMap(val mMutableMap: MutableMap<String, Any?>) {
    val name: String by mMutableMap
    val url: String by mMutableMap
}

fun 把属性储存在映射中var属性() {

    var mMutableMap:MutableMap<String, Any?> = mutableMapOf(
        "name" to "菜鸟教程",
        "url" to "www.runoob.com"
    )

    val site = SiteMutableMap(mMutableMap)

    println(site.name)
    println(site.url)

    println("--------------")
    mMutableMap.put("name", "Google")
    mMutableMap.put("url", "www.google.com")

    println(site.name)
    println(site.url)

}

class MainActivity : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testButton = findViewById<View>(R.id.TestButton) as Button

        testButton.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        when (view.id) {
            //R.id.TestButton -> Log.e("ok","ok")
            R.id.TestButton -> 把属性储存在映射中var属性()
        }
    }
}

