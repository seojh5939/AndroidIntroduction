package bootcamp.sparta.androidintroductionproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import bootcamp.sparta.androidintroductionproject.abstract.BaseActivity

class SignInActivity : BaseActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var et_id_signIn: EditText
    private lateinit var et_pw_signIn: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initViews()
        buttonClickedListeners()
        resultSignUp()
    }

    override fun initViews() {
        et_id_signIn = findViewById<EditText>(R.id.et_id_signIn)
        et_pw_signIn = findViewById<EditText>(R.id.et_pw_signIn)
    }

    // 버튼 OnClick 이벤트 등록
    override fun buttonClickedListeners() {
        signInButtonClickListener()
        signUpButtonClickListener()
    }

    private fun signInButtonClickListener() {
        if (inputIsEmpty(et_id_signIn, et_pw_signIn)) {
            showToastMsg(this, getString(R.string.toast_sign_in_fail))
        }

        if (!inputIsEmpty(et_id_signIn, et_pw_signIn)) {
            val userId = et_id_signIn.text.toString()
            val intent_home = Intent(this, HomeActivity::class.java)
            intent_home.putExtra(getString(R.string.intent_extra_id), userId)
            startActivity(intent_home)

            showToastMsg(this, getString(R.string.toast_sign_in_success))
        }
    }

    private fun signUpButtonClickListener() {
        val intent_join = Intent(this, SignUpActivity::class.java)
        resultLauncher.launch(intent_join)
    }

    private fun resultSignUp() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val id = result.data?.getStringExtra(getString(R.string.intent_extra_id) ?: "")
                    val pw = result.data?.getStringExtra(getString(R.string.intent_extra_pw) ?: "")
                    et_id_signIn.setText(id)
                    et_pw_signIn.setText(pw)
                }
            }

    }
}