package bootcamp.sparta.androidintroductionproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    lateinit var idEditText: EditText
    lateinit var pwEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        idEditText = findViewById<EditText>(R.id.et_id_signIn)
        pwEditText = findViewById<EditText>(R.id.et_pw_signIn)
    }

    fun onClickedButton(view: View) {
        when (view.id) {
            R.id.btn_login_signIn -> {
                if (inputIsEmpty()) {
                    showToastMsg(this, getString(R.string.toast_sign_in_fail))
                }

                if (!inputIsEmpty()) {
                    val userId = idEditText.text.toString()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra(getString(R.string.intent_extra_id), userId)
                    startActivity(intent)

                    showToastMsg(this, getString(R.string.toast_sign_in_success))
                }
            }

            R.id.btn_join_signIn -> {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // editText의 값이 비어있는지 체크
    fun inputIsEmpty(): Boolean = idEditText.text.isEmpty() || pwEditText.text.isEmpty()
    fun showToastMsg(context: Context, msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

}