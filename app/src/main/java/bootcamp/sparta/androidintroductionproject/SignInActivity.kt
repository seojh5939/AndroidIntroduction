package bootcamp.sparta.androidintroductionproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    lateinit var idEditText: EditText
    lateinit var pwEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        idEditText = findViewById<EditText>(R.id.et_id)
        pwEditText = findViewById<EditText>(R.id.et_pw)
    }

    fun onClickedButton(view: View) {
        when (view.id) {
            R.id.btn_login -> {
                if (inputIsEmpty()) {
                    showToastMsg(this, getString(R.string.toast_et_Empty))
                }

                if (!inputIsEmpty()) {
                    val userId = idEditText.text.toString()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("idDatFromSignInActivity", userId)
                    startActivity(intent)

                    showToastMsg(this, getString(R.string.toast_login_success))
                }
            }

            R.id.btn_join -> {
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