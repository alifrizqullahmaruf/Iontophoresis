package com.example.iontophoresis.Public.Monitoring

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iontophoresis.Adapter.AdapterHistory
import com.example.iontophoresis.Model.Treatment
import com.example.iontophoresis.Model.User
import com.example.iontophoresis.databinding.FragmentUpcomingMonitoringBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 * Use the [UpcomingMonitoringFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpcomingMonitoringFragment : Fragment() {
    private lateinit var binding: FragmentUpcomingMonitoringBinding
    private lateinit var firebaseFirestore: FirebaseFirestore
    private lateinit var firebaseAuth: FirebaseAuth
    private val UpcomingList: MutableLiveData<List<Treatment>> by lazy {
        MutableLiveData<List<Treatment>>()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpcomingMonitoringBinding.inflate(layoutInflater,container,false)
        firebaseFirestore = FirebaseFirestore.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()


        return binding.root
    }
    private fun observeHistory() {
        UpcomingList.observe(requireActivity()) { History ->
            val adapter = AdapterHistory(History,
                onDelete = { plan -> },
                onDetails = { plan -> }
            )
            binding.recycleUpcoming.adapter=adapter
            binding.recycleUpcoming.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeHistoryChange() {
        firebaseFirestore.collection("Treatments").addSnapshotListener { snapshots, error ->
            // jika dia terjadi error maka dia akan memunculkan log
            if (error != null) {
                Log.e("testttt", "Error listening for movies changes: ", error)
                return@addSnapshotListener
            }
            val user = firebaseAuth.currentUser?.uid
            var username = ""

            firebaseFirestore.collection("Users").document(user.toString()).get()
                .addOnSuccessListener {
                    val userData = it.toObject(User::class.java)
                    username = userData?.name.toString()
                }

            // jika gak error maka akan langsung ke sini
            val data = snapshots?.toObjects(Treatment::class.java)
            if (data != null) {
                val list = arrayListOf<Treatment>()
                for (i in data) {
//                    if (i.PasienName.equals(username)){
//                        list.add(i)
//                    }
                    list.add(i)
                }
                UpcomingList.postValue(list)
            }
        }
    }

}