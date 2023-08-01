package bootcamp.sparta.androidintroductionproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class HomeActivity : AppCompatActivity() {
    lateinit var iv_profile: ImageView
    lateinit var tv_id: TextView
    lateinit var tv_name: TextView
    lateinit var tv_age: TextView
    lateinit var tv_mbti: TextView
    lateinit var btn_exit : Button
    val imgArr = arrayListOf<Int>(R.drawable.img_home_profile_1, R.drawable.img_home_profile_2, R.drawable.img_home_profile_3, R.drawable.img_home_profile_4, R.drawable.img_home_profile_5)
    val rand = Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
        setExtraString()
        iv_profile.setImageResource(R.drawable.img_home_profile_5)
        btn_exit.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        setRandomProfile()
    }


    fun init() {
        iv_profile = findViewById(R.id.iv_profile)
        tv_name = findViewById(R.id.tv_name_home)
        tv_id = findViewById(R.id.tv_id_home)
        tv_age = findViewById(R.id.tv_age_home)
        tv_mbti = findViewById(R.id.tv_mbti_home)
        btn_exit = findViewById(R.id.btn_exit_home)
    }

    fun setExtraString() {
        tv_id.text = intent.getStringExtra(getString(R.string.intent_extra_id))
        tv_name.setText("서정한")
        tv_age.setText("34")
        tv_mbti.setText("ISTJ")
    }

    private fun setRandomProfile() {
        var idx = 0
        idx = rand.nextInt(0 until imgArr.size)
        iv_profile.setImageResource(imgArr[idx])
    }
}