package com.example.iontophoresis.Adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.iontophoresis.Public.Dosis.DosisHistoryFragment
import com.example.iontophoresis.Public.Dosis.DosisHomeFragment

class TabAdapter(ac:AppCompatActivity):FragmentStateAdapter(ac) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment:Fragment?=null
        when(position){
            0->fragment=DosisHomeFragment()
            1->fragment=DosisHistoryFragment()
        }
        return fragment as Fragment
    }

}