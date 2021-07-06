package com.example.runoobkotlintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

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
            R.id.TestButton -> 接口中的属性()
        }
    }
}

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