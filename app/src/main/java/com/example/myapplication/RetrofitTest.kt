package com.example.myapplication

import android.net.Uri
import android.util.Log
import com.example.myapplication.login.LoginResponse
import com.example.myapplication.login.LoginSend
import com.example.myapplication.register.RegisterResponse
import com.example.myapplication.register.UserLocation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Url
import java.net.URI
import java.net.URLDecoder


fun main() {
    lateinit var retrofit: Retrofit
    lateinit var myAPI: RetrofitService
    retrofit = RetrofitClient.getInstnace() // 2에서 만든 Retrofit client의 instance를 불러옵니다.
    myAPI = retrofit.create(RetrofitService::class.java)
    /*
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
    var a = UserLocation("관악","신림")
    Runnable {
        myAPI.register(
            "hogi",
            "1234",
            "gogi",
            a
        ).enqueue(object : Callback<RegisterResponse> {

            //이때 onFaliure는 Cal을 서버쪽으로 아예 보내지 못한 경우입니다.
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                println(t.message)
            }


            //만약 보낸 것이 성공했을 경우는 resonse를 가지고 들어옵니다.
            //그리고 call을 때릴 때 RawResponseData로 갔으니까 Reponse도 그 타입을 가지고 옵니다.
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                println("response : ${response.body()!!}")

                println("response : ${response.errorBody()}")
                println("response : ${response.message()}")
                println("response : ${response.code()}")
                println("response : ${response.raw().request().url().url()}")
            }
        })
    }.run()
     */

    Runnable {
        val a = LoginSend("hogi","1234")
        myAPI.login(
            a
        ).enqueue(object : Callback<LoginResponse> {

            //이때 onFaliure는 Call을 서버쪽으로 아예 보내지 못한 경우입니다.
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println(t.message)
            }


            //만약 보낸 것이 성공했을 경우는 resonse를 가지고 들어옵니다.
            //그리고 call을 때릴 때 RawResponseData로 갔으니까 Reponse도 그 타입을 가지고 옵니다.
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                println("response : ${response.errorBody()}")
                println("response : ${response.message()}")
                println("response : ${response.code()}")
                println("response : ${response.raw().request().url().url()}")
                println("response : ${response.body()!!}")
                println(response.body()!!.id)
            }
        })
    }.run()
/*
    Runnable {
        myAPI.test(
        ).enqueue(object : Callback<Test> {

            //이때 onFaliure는 Cal을 서버쪽으로 아예 보내지 못한 경우입니다.
            override fun onFailure(call: Call<Test>, t: Throwable) {
                println(t.message)
            }


            //만약 보낸 것이 성공했을 경우는 resonse를 가지고 들어옵니다.
            //그리고 call을 때릴 때 RawResponseData로 갔으니까 Reponse도 그 타입을 가지고 옵니다.
            override fun onResponse(
                call: Call<Test>,
                response: Response<Test>
            ) {
                println("response : ${response.body()!!}")
                println("response : ${response.errorBody()}")
                println("response : ${response.message()}")
                println("response : ${response.code()}")
                println("response : ${response.raw().request().url().url()}")
            }
        })
    }.run()

 */
}

