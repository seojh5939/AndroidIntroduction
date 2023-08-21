package bootcamp.sparta.androidintroductionproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import bootcamp.sparta.androidintroductionproject.abstract.BaseActivity

class SignUpActivity : BaseActivity() {
    private lateinit var et_name: EditText
    private lateinit var et_id: EditText
    private lateinit var et_pw: EditText
    private lateinit var bt_join: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        buttonClickedListeners()
    }

    override fun initViews() {
        et_name = findViewById(R.id.et_name_signUp)
        et_id = findViewById(R.id.et_id_signUp)
        et_pw = findViewById(R.id.et_pw_signUp)
        bt_join = findViewById(R.id.btn_join_signUp)
    }

    override fun buttonClickedListeners() {
        signUpButtonClickListener()
    }

    private fun signUpButtonClickListener() {
        if (inputIsEmpty(et_name, et_id, et_pw)) {
            showToastMsg(this, getString(R.string.toast_sign_up_fail))
        }

        if (!inputIsEmpty(et_name, et_id, et_pw)) {
            val intent_signup = Intent(this, SignInActivity::class.java)
            intent_signup.putExtra(getString(R.string.intent_extra_id), et_id.text.toString())
            intent_signup.putExtra(getString(R.string.intent_extra_pw), et_pw.text.toString())
            setResult(RESULT_OK, intent_signup)

            showToastMsg(this, getString(R.string.toast_sign_up_success))
            finish()
        }
    }
}