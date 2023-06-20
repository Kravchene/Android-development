package dev.lynko.cources2023


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast

import com.example.android_development.databinding.ActivityMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
//import androidx.lifecycle.lifecycleScope
import kotlin.random.Random

class RxJavaWorkShop : AppCompatActivity() {

    private var TAG = "MainActivity"

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            startRStream()
        }
    }

    private fun startRStream() {

        val myObservable = getObservable()

        val myObserver = getObserver()

        myObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(myObserver);

    }
    private fun getObserver():Observer<Int> {
        return object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                Toast.makeText(this@RxJavaWorkShop, "onSubscribe", Toast.LENGTH_SHORT).show()
            }
            override fun onNext(t: Int) {
                Toast.makeText(this@RxJavaWorkShop, "onNext: $t", Toast.LENGTH_SHORT).show()
            }

            override fun onError(e: Throwable) {
                Toast.makeText(this@RxJavaWorkShop, "onError", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                Toast.makeText(this@RxJavaWorkShop, "onComplete", Toast.LENGTH_SHORT).show()
            }

            }
        }
    }
    private fun getObservable(): Observable<Int> {
        return Observable.just(5,4,3,2,1)
    }


