package com.ezdream.qrscanner.ui.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ezdream.qrscanner.R
import com.ezdream.qrscanner.databinding.ActivityLoginBinding
import com.ezdream.qrscanner.ui.home.HomeActivity
import com.ezdream.qrscanner.util.UiUtil.getDuration
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("TAG", "onCreate: LoginActivity")

        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[LoginActivityVM::class.java]
        setContentView(binding.root)


        val duration = getDuration(applicationContext,R.drawable.splash3)
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(duration.toLong() * 6)
                    val intent = Intent(baseContext, HomeActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

    }
}