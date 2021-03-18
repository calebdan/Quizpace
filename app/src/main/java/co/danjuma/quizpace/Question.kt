package co.danjuma.quizpace

data class Question(
    val id: Int,
    val q:String,
    val optionOne: String,
    val optionTwo:String,
    val optionThree:String,
    val correctAnswer: Int
)
