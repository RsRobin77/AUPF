package com.daffodil.varsity.aupf.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.ui.fragment.tabs.EventsTab
import com.daffodil.varsity.aupf.ui.fragment.tabs.NearbyTabs
import com.google.android.material.tabs.TabLayout
import room.database.events.EventViewModel

/**
 * A simple [Fragment] subclass.
 */
class NearbyFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_nearby, container, false)

        try {
            setupTabView()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

        return rootView
    }

    private fun setupTabView() {

        val tabLayout = rootView.findViewById<TabLayout>(R.id.tabs)
        val viewPager = rootView.findViewById<ViewPager>(R.id.view_pager)

        if (tabLayout == null)
            Toast.makeText(context, "Null", Toast.LENGTH_SHORT).show()


        val sectionsPagerAdapter = fragmentManager?.let { SectionsPagerAdapter(it) }

        viewPager?.adapter = sectionsPagerAdapter

        tabLayout?.setupWithViewPager(viewPager)

        tabLayout?.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))

        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout).apply {

        })
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        private val names = arrayOf("Restaurants", "Shopping Mall", "Movie Theater & Games", "Mosque","Money Exchange")

        override fun getItem(position: Int): Fragment {
            return NearbyTabs.newInstance(names[position])
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return names[position]
        }


    }

}// Required empty public constructor
