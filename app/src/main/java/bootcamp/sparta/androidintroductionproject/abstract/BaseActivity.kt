package bootcamp.sparta.androidintroductionproject.abstract

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){
    open fun init() {}

    fun showToastMsg(context: Context, msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}