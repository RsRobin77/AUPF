package com.daffodil.varsity.aupf.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.ui.fragment.tabs.EventsTab
import com.google.android.material.tabs.TabLayout
import room.database.events.DailyEvent
import room.database.events.EventAdapter
import room.database.events.EventViewModel


/**
 * A [Fragment] of Daily Event lists. Where the list of events in a day will be shown here.
 */
class DailyEvents : Fragment() {
    private lateinit var eventViewModel: EventViewModel

    private lateinit var rootView:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_daily_events, container, false)

        try {
            setupTabView()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        }

        return rootView
    }

    private fun setupTabView() {

        val tabLayout = rootView!!.findViewById<TabLayout>(R.id.tabs)
        val viewPager = rootView!!.findViewById<ViewPager>(R.id.view_pager)

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

        override fun getItem(position: Int): Fragment {
            return EventsTab.newInstance("day${position + 1}")
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return "Day ${position + 1}"
        }
    }

}
