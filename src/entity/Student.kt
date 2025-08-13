package entity

class Student(score:Int) : Person() {
    var grade:Int = 0
    private var isPassed: Boolean = false
    init {
        if(score in 0..100){
            this.grade = score
            if(score > 60 && score < 100){
                this.isPassed = true
            }
        }else{
            this.grade = 0
        }
        println("Student Grade: $grade")
        println("Student isPass?: $isPassed")
    }
}