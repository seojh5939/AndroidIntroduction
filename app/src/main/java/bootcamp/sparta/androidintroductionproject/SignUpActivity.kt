package bootcamp.sparta.androidintroductionproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    lateinit var et_name : EditText
    lateinit var et_id : EditText
    lateinit var et_pw : EditText
    lateinit var bt_join : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()
    }

    fun init() {
        et_name = findViewById(R.id.et_name_signUp)
        et_id = findViewById(R.id.et_id_signUp)
        et_pw = findViewById(R.id.et_pw_signUp)
        bt_join = findViewById(R.id.btn_join_signUp)
    }

    fun onClickedButtonSignUp(view: View) {
        if(inputIsEmpty()) {
            showToastMsg(this, getString(R.string.toast_sign_up_fail))
        }

        if(!inputIsEmpty()) {
            showToastMsg(this, getString(R.string.toast_sign_up_success))
            finish()
        }
    }

    fun inputIsEmpty(): Boolean = et_name.text.isEmpty() || et_id.text.isEmpty() || et_pw.text.isEmpty()

    fun showToastMsg(context: Context, msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

}