package co.danjuma.quizpace

object Constants {

    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "Nigeria is the African continent’s largest economy, as well as its largest ___ producer.",
            "gemstone",
            "Cocoa",
            "Oil",
            3
        )

        questionsList.add(que1)

        val que2 = Question(
            2,
            "In 1991, Nigeria’s capital city changed from Lagos to___",
            "Benue",
            "Abuja",
            "Kaduna",
            2
        )

        questionsList.add(que2)

        val que3 = Question(
            3,
            "Almost one in every __ people in sub-Saharan Africa is Nigerian. This question is required.",
            "2",
            "5",
            "10",
            2
        )

        questionsList.add(que3)

        val que4 = Question(
            4,
            "In 2017, Nigeria had the seventh-largest population in the world. In 2050, what is its rank expected to be?",
            "3rd",
            "5th",
            "6th",
            1
        )

        questionsList.add(que4)


        val que5 = Question(
            5,
            "In what year did Nigeria gain independence from the United Kingdom?",
            "1960",
            "1941",
            "2020",
            1
        )

        questionsList.add(que5)


        val que6 = Question(
            6,
            "In 1967, three states of Nigeria seceded, sparking a civil war. What name did these states adopt in their attempt at independence?",
            "Igboland",
            "Biafra",
            "Lagos",
            2
        )

        questionsList.add(que6)


        return questionsList
    }


}