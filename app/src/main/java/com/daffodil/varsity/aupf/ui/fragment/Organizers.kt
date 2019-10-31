package com.daffodil.varsity.aupf.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.adapter.PartnersAdapter
import com.daffodil.varsity.aupf.model.Partner
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class Organizers : Fragment() {

    private val partnerList = ArrayList<Partner>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootLayout = inflater.inflate(R.layout.fragment_organizers, container, false)

        /**because of the same parameter for partners and organizers we used partners adapter also
         *for this list adapter
         * */

        val recyclerView  = rootLayout.findViewById<RecyclerView>(R.id.recycler_view_organizers)

        recyclerView.apply {
            hasFixedSize()
            layoutManager =LinearLayoutManager(context)

            adapter = PartnersAdapter(context,partnerList)
        }


        return rootLayout
    }

    init {
        partnerList.add(Partner("Daffodil Family", R.drawable.partner_group))
        partnerList.add(Partner("Daffodil International University", R.drawable.partner_diu))
        partnerList.add(Partner("Daffodil Educational Network", R.drawable.partner_dia_bcs))
        partnerList.add(Partner("Daffodil Computer Limited", R.drawable.partner_dcl))
        partnerList.add(Partner("Daffodil Software Limited", R.drawable.partner_dsl))

    }


}
