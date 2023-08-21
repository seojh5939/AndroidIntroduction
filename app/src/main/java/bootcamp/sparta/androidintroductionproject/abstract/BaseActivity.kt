package bootcamp.sparta.androidintroductionproject.abstract

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    // view Init
    abstract fun initViews()

    // 각 Activity에서 버튼의 onClickEvent 등록메서드
    open fun buttonClickedListeners() {}

    fun showToastMsg(context: Context, msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    // EditText의 text값이 비어있는지 검증
    open fun inputIsEmpty(et1: EditText, et2: EditText, et3: EditText? = null) : Boolean {
        if(et3 == null){
            return et1.text.isEmpty() || et2.text.isEmpty()
        }

        return et1.text.isEmpty() || et2.text.isEmpty() || et3.text.isEmpty()
    }
}