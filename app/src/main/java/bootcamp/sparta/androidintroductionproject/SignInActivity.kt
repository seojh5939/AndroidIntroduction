package bootcamp.sparta.androidintroductionproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher : ActivityResultLauncher<Intent>
   private lateinit var et_id_signIn: EditText
   private lateinit var et_pw_signIn: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        et_id_signIn = findViewById<EditText>(R.id.et_id_signIn)
        et_pw_signIn = findViewById<EditText>(R.id.et_pw_signIn)
        resultSignUp()
    }

    fun onClickedButton(view: View) {
        when (view.id) {
            R.id.btn_login_signIn -> {
                if (inputIsEmpty()) {
                    showToastMsg(this, getString(R.string.toast_sign_in_fail))
                }

                if (!inputIsEmpty()) {
                    val userId = et_id_signIn.text.toString()
                    val intent_home = Intent(this, HomeActivity::class.java)
                    intent_home.putExtra(getString(R.string.intent_extra_id), userId)
                    startActivity(intent_home)

                    showToastMsg(this, getString(R.string.toast_sign_in_success))
                }
            }

            R.id.btn_join_signIn -> {
                val intent_join = Intent(this, SignUpActivity::class.java)
                resultLauncher.launch(intent_join)
            }
        }
    }

    private fun resultSignUp() {
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val id = result.data?.getStringExtra(getString(R.string.intent_extra_id) ?: "")
                val pw = result.data?.getStringExtra(getString(R.string.intent_extra_pw) ?: "")
                et_id_signIn.setText(id)
                et_pw_signIn.setText(pw)
            }
        }

    }

    // editText의 값이 비어있는지 체크
   private fun inputIsEmpty(): Boolean = et_id_signIn.text.isEmpty() || et_pw_signIn.text.isEmpty()
   private fun showToastMsg(context: Context, msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}