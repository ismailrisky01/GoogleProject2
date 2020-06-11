package com.example.googleproject2.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.googleproject2.R
import com.example.googleproject2.model.LoginModel
import com.example.googleproject3.APIService
import com.example.googleproject3.RestClient
import kotlinx.android.synthetic.main.fragment_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private var mApiService: APIService? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BtnLogin(view)

    }

    private fun Login(username: String, password: String, view: View) {

        val requestBody: MutableMap<String, String> = HashMap()
        requestBody["username"] = username
        requestBody["password"] = password
        Log.d("tag", "" + username + password)
        mApiService = RestClient.client.create(APIService::class.java)
        val call = mApiService!!.Login(username, password)
        call.enqueue(object : Callback<LoginModel> {
            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                val questions = response.body()
                if (questions!!.status.equals(200)) {
                    Toast.makeText(context, "" + questions.message, Toast.LENGTH_SHORT).show()
                    //dataList.addAll( questions.data!!)
//                    val bundle = Bundle()
//                    bundle.putString("key",)
//                    bundle.putString("id",password)
//                    val intent = Intent(context, DashboardActivity::class.java)
//                    intent.putExtras(bundle)
//                    startActivity(intent)


                } else {
                    Toast.makeText(context, "" + questions.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

    fun BtnLogin(view: View) {
        Btn_Login.setOnClickListener {
            val username = username.text
            val password = password.text
            Login(username.toString(), password.toString(), view)
        }

    }
}
