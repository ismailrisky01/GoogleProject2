package com.example.googleproject2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googleproject2.model.LoginData
import com.example.googleproject3.APIService
import com.example.googleproject3.RestClient
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.util.ArrayList
import javax.security.auth.callback.Callback

/**
 * A simple [Fragment] subclass.
 */
class DashboardFragment : Fragment() {
    private var mApiService: APIService? = null
    private var mAdapter: DashboardAdapter?= null
    private var dataList: MutableList<LoginData> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       initView()
    }

    fun initView(){
        mApiService = RestClient.client.create(APIService::class.java)
        listRecyclerView!!.layoutManager =LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        mAdapter = DashboardAdapter(context!!,dataList,R.layout.list_item)
        listRecyclerView!!.adapter = mAdapter
        getData()
    }

    fun getData(){
        mApiService = RestClient.client.create(APIService::class.java)
        val call = mApiService!!.Data()
        call.enqueue(object : Callback<>)
    }

}
