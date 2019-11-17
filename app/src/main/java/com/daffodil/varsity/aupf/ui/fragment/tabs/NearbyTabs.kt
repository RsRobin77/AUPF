package com.daffodil.varsity.aupf.ui.fragment.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.adapter.NearbyAdapter
import java.util.*

private const val DAY = "param1"

class NearbyTabs : Fragment() {
    private val names = arrayOf("Restaurants", "Shopping Mall", "Movie Theater & Games", "Mosque", "Money Exchange")

    private var location: String? = null
    private var listOfLocation = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            location = it.getString(DAY)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_tabs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        try {
            val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
            val nearbyAdapter = NearbyAdapter(location?.let { location(it) })

            recyclerView.apply {
                hasFixedSize()
                layoutManager = LinearLayoutManager(context)
                adapter = nearbyAdapter
            }

        } catch (nullPointer: KotlinNullPointerException) {
            nullPointer.printStackTrace()
        }
    }

    private fun location(location: String): List<String> {
        if (location == names[0]) {
            listOfLocation.add("Water Garden Brasserie (inside the hotel ) ")
            listOfLocation.add("Spice and Rice (inside the hotel)")
            listOfLocation.add("Le meridian ")
            listOfLocation.add("Kabab Ghar (near airport )")
            listOfLocation.add("Cooper’s bakery (147, vip old airport ) ")
            listOfLocation.add("Turkish Kabab (sector 4 ,uttara ) ")
            listOfLocation.add("Istanbul Restaurant (Gulsan 1 ) ")
            listOfLocation.add("Pool Bar ( inside le meridian ) ")
            listOfLocation.add("Beans and Aroma (sector 4 )  ")
            listOfLocation.add("Palm View (sector 4 ) ")
            listOfLocation.add("Fire on Ice ( music live café sector 4 ) ")
            listOfLocation.add("Nandos (Gulsan ) ")
            listOfLocation.add("Butlers Chocolate Café (Gulsan 1)  best for snacks after evening ")
            listOfLocation.add("Six Season (Gulsan 1) best for snacks after evening ")
            listOfLocation.add("Café Bistro (Gulsan 1 ) best for snacks after evening ")
            listOfLocation.add("Sky Tree Lounge (Gulsan 1 ) best for snacks after evening ")
            listOfLocation.add("Café Memoire ( sector 11)  ")
            listOfLocation.add("Nagasaki Japanese Restaurant (sector 9 ) ")
        }

        if (location == names[1]) {
            listOfLocation.add("Unimart (Gulsan ) ")
            listOfLocation.add("Yellow, sailor , red origin , many more (sector 11) ")
            listOfLocation.add("Aarong (sector 4 )")
            listOfLocation.add("Miniso (sector 11,7)")
            listOfLocation.add("Gulsan pink city (gulsan)")
            listOfLocation.add("Jamuna Future Park ")
        }

        if (location == names[2]) {
            listOfLocation.add("Blockbuster (jamuna future park )")
            listOfLocation.add("Star Cineplex( bashundara city )")
        }

        if (location == names[3]) {
            listOfLocation.add("Golf club Garden Mosjid near Radisson Blu Dhaka Water Garden\n")
        }

        if (location == names[4]) {
            listOfLocation.add("sector 4 Uttara, near Gulsan and inside the hotel")
        }

        return listOfLocation
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param day Parameter 1.
         * @return A new instance of fragment EventsTab.
         */
        @JvmStatic
        fun newInstance(day: String) =
                NearbyTabs().apply {
                    arguments = Bundle().apply {
                        putString(DAY, day)
                    }
                }
    }
}