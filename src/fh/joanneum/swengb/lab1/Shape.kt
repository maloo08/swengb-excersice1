package fh.joanneum.swengb.lab1

open class Shape(val color:String = "black") {
    open fun getArea():Double {
        return 0.0

    }

    override fun toString(): String {
        return "Shape(color='$color')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Shape

        if (color != other.color) return false

        return true
    }

    override fun hashCode(): Int {
        return color.hashCode()
    }
}

class Rectangle(color:String = "black", val width:Double = 1.0, val length:Double = 1.0): Shape(color){
    override fun getArea(): Double {
        return width * length

    }

    override fun toString(): String {
        return "Rectangle(width=$width, length=$length, color=$color)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (width != other.width) return false
        if (length != other.length) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width.hashCode()
        result = 31 * result + length.hashCode()
        return result
    }
}

class Circle(color:String = "blue", val radius:Double = 1.0): Shape(color){
    override fun getArea(): Double {
        return radius * radius * Math.PI

    }

    override fun toString(): String {
        return "Circle(radius=$radius, color=$color)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false

        return true
    }

    override fun hashCode(): Int {
        return radius.hashCode()
    }
}


fun main() {
    val testShape = Shape()
    println(testShape.color)

    val testRectangle = Rectangle(width = 5.0, length = 2.0 )
    println(testRectangle)
    testRectangle.length

    val aShape: Shape = testRectangle
    //aShape.width
    println(aShape.getArea())

    val testCircle = Circle(radius = 10.0, color = "red")
    println(testCircle)

    val circle1 = Circle(radius = 10.0, color = "red")
    val circle2 = Circle(radius = 10.0, color = "red")
    println(circle1 === circle2)
    println(circle1 == circle2)
    println(setOf<Circle>(circle1, circle2).size)

    val canvas = Canvas()
    canvas.addShape(Rectangle("white", width = 5.0, length = 2.0))
    canvas.addShape(Circle("red", radius = 1.0))
    println(canvas.getTotalArea())


}