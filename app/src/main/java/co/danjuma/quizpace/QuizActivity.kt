package co.danjuma.quizpace

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import co.danjuma.quizpace.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0


    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val value = intent.getStringExtra("MAINACTIVITY_KEY")

        binding.tvUserGreeting.text = "hello, $value"

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mQuestionList = Constants.getQuestion()

        setQuestion()



        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionOne.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        defaultOptionsView()

        binding.tvProgress.text = "$mCurrentPosition " + "of " + mQuestionList!!.size.toString()

        binding.tvQuestion.text = question.q
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
    }


    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)

        for (option in options) {
            option.setTextColor(Color.parseColor("#FFFFFF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.tv_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(binding.tvOptionOne, 1)

                Handler().postDelayed({

                    mCurrentPosition++
                    setQuestion()

                }, 2200)
            }

            R.id.tv_option_two -> {
                selectedOptionView(binding.tvOptionTwo, 2)
                mCurrentPosition++
                setQuestion()
            }

            R.id.tv_option_three -> {

                selectedOptionView(binding.tvOptionThree, 3)
                mCurrentPosition++
                setQuestion()
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding
                    .tvOptionOne
                    .background =
                    ContextCompat
                        .getDrawable(this,
                            drawableView)
            }

            2 -> {
                binding.tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                binding.tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }


    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {

        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#FFFFFF"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.btn_selected
        )

        if (mSelectedOptionPosition == 0) {
            mCurrentPosition++
            when {
                mCurrentPosition <= mQuestionList!!.size -> {
                    setQuestion()
                }
                else -> {
                    Toast.makeText(
                        this, "The quiz have been completed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        } else {
            val question = mQuestionList?.get(mCurrentPosition - 1)
            if (question!!.correctAnswer != mSelectedOptionPosition) {
                answerView(mSelectedOptionPosition, R.drawable.wrong_bg)

            }
            answerView(question.correctAnswer, R.drawable.right_btn_bg)
        }
    }
}