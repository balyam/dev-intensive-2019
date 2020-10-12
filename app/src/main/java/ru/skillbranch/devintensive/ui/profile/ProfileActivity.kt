package ru.skillbranch.devintensive.ui.profile

import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_profile.*
import ru.skillbranch.devintensive.R
import ru.skillbranch.devintensive.models.Profile
import ru.skillbranch.devintensive.viewmodels.ProfileViewModel

class ProfileActivity : AppCompatActivity() {

    companion object{
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }

    var isEditMode = false
    lateinit var viewFields: Map<String, TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews(savedInstanceState)
        initViewModel()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean(IS_EDIT_MODE, isEditMode)
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.getProfileData().observe(this, Observer { updateUI(it) })
    }

    private fun updateUI(profile: Profile?){
        profile?.toMap().also {
            for ((k, v) in viewFields) {
                v.text = it?.get(k).toString()
            }
        }
    }

    private fun initViews(savedInstanceState: Bundle?) {
        viewFields = mapOf(
                "nickname" to tv_nick_name,
                "rank" to tv_rank,
                "rating" to tv_rating,
                "respect" to tv_respect,
                "firstname" to et_first_name,
                "lastname" to et_last_name,
                "repository" to et_repository,
                "about" to et_about
        )

        isEditMode = savedInstanceState?.getBoolean(IS_EDIT_MODE, false) ?: false
        showCurrentMode(isEditMode)

        btn_edit.setOnClickListener(View.OnClickListener {
            isEditMode = !isEditMode
            showCurrentMode(isEditMode)
        })
    }

    private fun showCurrentMode(isEdit: Boolean) {
        val info = viewFields.filter { setOf("firstname", "lastname", "repository", "about").contains(it.key) }

        for ((_,v ) in info) {
            v as TextInputEditText
            v.isFocusable = isEdit
            v.isFocusableInTouchMode = isEdit
            v.isEnabled = isEdit
            v.background.alpha = if (isEdit) 255 else 0
        }

        iv_eye.visibility = if(isEdit) View.GONE else View.VISIBLE
        wr_about.isCounterEnabled = isEdit

        with(btn_edit){
            val filter: ColorFilter? = if(isEdit) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    PorterDuffColorFilter(
                            resources.getColor(R.color.color_accent, theme),
                            PorterDuff.Mode.SRC_IN
                    )
                } else {
                    PorterDuffColorFilter(
                            ContextCompat.getColor(context, R.color.color_accent),
                            PorterDuff.Mode.SRC_IN
                    )

                }
            }
            else{
                null
            }
            val icon = if(isEdit){
                resources.getDrawable(R.drawable.ic_save_black_24dp)
            }else{
                resources.getDrawable(R.drawable.ic_edit_black_24dp)
            }
            background.colorFilter = filter
            setImageDrawable(icon)

    }

}
}


