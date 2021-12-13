package com.example.endeavorapp.ui.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build.ID
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.endeavorapp.R
import com.example.endeavorapp.Retrofit.RetrofitClient
import com.example.endeavorapp.Retrofit.Services
import com.example.endeavorapp.data.Message
import com.example.endeavorapp.list.MessagingAdapter
import com.example.endeavorapp.model.User
import com.example.endeavorapp.ui.HomeActivity

import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.endeavorapp.ui.EMAIL
import com.example.endeavorapp.ui.PREF_NAME


const val FOLLOWERS = "FOLLOWERS"
const val NBPOST = "NBPOST"



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
    lateinit var post_add :Button
    lateinit var mSharedPref: SharedPreferences
    lateinit var post_message: EditText
    lateinit var services: Services
    //  lateinit var auth: FirebaseAuth
    lateinit var addComment : FloatingActionButton
    var messagesList = mutableListOf<Message>()
    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("Peter", "Francesca", "Luigi", "Igor")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_chat, container, false)

     //   super.onViewCreated(view, savedInstanceState)


        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        post_add= view.findViewById(R.id.btn_send)
        post_message= view.findViewById(R.id.et_message)
        val retrofit =  RetrofitClient.getInstance()
        services = retrofit.create(Services::class.java)
        //val editor = context!!.getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
        //  val editor = requireContext().getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit()
        //  mSharedPref  = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        mSharedPref = view.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)


        post_add.setOnClickListener {
            services.AddPost(mSharedPref.getString(EMAIL,"").toString(),post_message.text.toString()).enqueue(object :Callback<User>{
                //  services.AddPost("emna@esprit.tn",post_message.text.toString()).enqueue(object :Callback<User>{
                //  services.AddPost(1111,post_message.text.toString()).enqueue(object :Callback<User>{
                override fun onResponse(call :Call<User>, response:
                Response<User>){
                    val user =response.body()
                    if (user != null){
                        mSharedPref.edit().apply{
                            //       putString(FOLLOWERS,user.followers.size.toString())
                            //      putString(NBPOST,user.post.size.toString())
                        }.apply()
                        post_message.text.clear()
                        val intent= Intent(context,HomeActivity::class.java)
                        startActivity(intent)

                    }
                    else{

                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    post_message.text.clear()
                    val intent =Intent(context,HomeActivity::class.java)
                    startActivity(intent)
                }

            })
        }
    }

    private fun cmt() {
        TODO("Not yet implemented")
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            ChatFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }


}