package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.net.URLDecoder

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var myAPI: RetrofitService // 작성한 API interface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //retrofit setting
        retrofit = RetrofitClient.getInstnace() // 작성한 retrofit 객체 불러옴
        myAPI = retrofit.create(RetrofitService::class.java) // retrofit 객체 생성
        // Runnable로 감싸주는 이유는
        // Android 에서 MainThread 네트워킹 관련 일 처리할떄
        // 새로운 스레드에서 실행 마지막에 .run() 잊지말 것
        Runnable {
            myAPI.getData(
                2020,
                1,
                2,
                "json",
                URLDecoder.decode("b1dS6r%2Fxe4bznhr5ulfrzvE1r7sHkYpUyUyvEY7nWCDX4sXjNLLG4bS5ibdkHjM12rTBlj%2B4FXGT7B%2FWE5UGdw%3D%3D", "UTF-8")

            ).enqueue(object : Callback<Data> {

                //이때 onFaliure는 Cal을 서버쪽으로 아예 보내지 못한 경우입니다.
                override fun onFailure(call: Call<Data>, t: Throwable) {
                    println(t.message)
                }


                //만약 보낸 것이 성공했을 경우는 resonse를 가지고 들어옵니다.
                //그리고 call을 때릴 때 RawResponseData로 갔으니까 Reponse도 그 타입을 가지고 옵니다.
                override fun onResponse(
                    call: Call<Data>,
                    response: Response<Data>
                ) {
                    //Log.d(TAG, "response : ${response.body()!!}") // 정상출력이 되야 합니다.
                    println("response : ${response.body()!!}")

                    //만약 정상 출력이 되지 않으면 문제가 있는 겁니다.
                    //이때는 Call은 제대로 보냈으나 서버에서 이거뭐냐? 하고 reponse를 보낸 경우 입니다.
                    println("response : ${response.errorBody()}")
                    println("response : ${response.message()}")
                    println("response : ${response.code()}")
                    println("response : ${response.raw().request().url().url()}")
                    text1.setText("response : ${response.body()}")

                    // Data class 멤버 인스턴스 접근
                    val a: Data = response.body()!!
                    println(a.response.body.items[0].districtName)

                    //Log.d(TAG, "response : ${response.errorBody()}")
                    //Log.d(TAG, "response : ${response.message()}")
                    //Log.d(TAG, "response : ${response.code()}") //이게 가장 에러를 알아보기 쉬운 곳 입니다.
                    //Log.d(
                    //    TAG,
                    //    "response : ${response.raw().request().url().url()}"
                    //) //무슨 url로 api call 을 보냈는지
                    //확인 할 수 있습니다.
                }
            })
        }.run()
    }
}