package com.yaka.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.concurrent.ScheduledExecutorService

class Main2Activity : AppCompatActivity() {
    val wikiApiServe by lazy {
        Api.create()
    }
    var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    private fun beginSearch(srsearch: String) {

        disposable =
                wikiApiServe.hitCountCheck("query", "json", "search", srsearch)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> {
                                    Toast.makeText(this, "Result loaded", Toast.LENGTH_LONG).show()
                                    textView2.text = "${result.query.searchinfo.totalhits} result found"
                                }},
                                { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
                        )
    }
    fun onButton(view: View){
        val inp: String=thor.text.toString()
        Toast.makeText(this,"Searching ...",Toast.LENGTH_LONG).show()
        beginSearch(inp)
    }
    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

}
