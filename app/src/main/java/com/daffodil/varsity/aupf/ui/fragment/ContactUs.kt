package com.daffodil.varsity.aupf.ui.fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.model.ContactAdmin
import android.content.pm.PackageManager
import android.content.Intent

import android.net.Uri
import android.widget.*


/**
 * A simple [Fragment] subclass.
 */
class ContactUs : Fragment() {

    private var listOfContact = ArrayList<ContactAdmin>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_contact_us, container, false)

        val adminContactAdapter = context?.let { AdminContactAdapter(it, listOfContact) }

        val adminRecyclerView = rootView.findViewById<RecyclerView>(R.id.contact_us)

        adminRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = adminContactAdapter
        }

        return rootView
    }

    init {

        listOfContact.add(ContactAdmin(
                R.drawable.fokhray1,
                "Professor Dr. Md. Fokhray Hossain",
                "Director of International Affairs, Daffodil International University",
                "international@daffodilvarsity.edu.bd\n" +
                        "aupf2019@daffodil.university\n" +
                        "secretariat.aupf2019@daffodil.university",
                "Cell : +8801713493250","01713493250")
        )
        listOfContact.add(ContactAdmin(
                R.drawable.raihan,

                "Mr. Syed Raihan-Ul-Islam",
                "Assistant Director\n" +
                        "International Affairs\n" +
                        "Daffodil International University\n",
                "int@daffodilvarsity.edu.bd\n" +
                        "aupf2019@daffodil.university\n",
                "Cell: +8801811458865\n" +
                        "WhatsApp: +8801920012744\n","01920012744")
        )
    }

    inner class AdminContactAdapter(private val context: Context, private val listOfContact: List<ContactAdmin>) :
            RecyclerView.Adapter<AdminContactAdapter.ContactHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
            val itemHolder = LayoutInflater.from(parent.context).inflate(R.layout.contact_us_item, parent, false)

            return ContactHolder(itemHolder)
        }

        override fun getItemCount(): Int {
            return listOfContact.size
        }

        override fun onBindViewHolder(holder: ContactHolder, position: Int) {
            val contactAdmin = listOfContact[position]

            try {
                Glide.with(context).load(contactAdmin.adminAvatar)
                        .centerCrop()
                        .optionalCircleCrop()
                        .into(holder.avatar)

            } catch (glideException: GlideException) {
                glideException.printStackTrace()
            }

            holder.name.text = contactAdmin.name.toString()
            holder.designation.text = contactAdmin.designation.toString()
            holder.mail.text = contactAdmin.mail.toString()
            holder.cell.text = contactAdmin.cell.toString()
            holder.whatsApp.setOnClickListener {

                whatsAppOpen(contactAdmin.whatsapp.toString())


            }

        }

        inner class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val avatar: ImageView = itemView.findViewById(com.daffodil.varsity.aupf.R.id.admin_avatar)!!
            val name = itemView.findViewById<TextView>(R.id.name_of_admin)!!
            val designation = itemView.findViewById<TextView>(R.id.designation_of_admin)!!
            val mail = itemView.findViewById<TextView>(R.id.mail_of_admin)!!
            val cell = itemView.findViewById<TextView>(R.id.cell_of_admin)!!
            val whatsApp = itemView.findViewById<Button>(R.id.contact_us)!!

        }

    }

    fun whatsAppOpen( num :String) {
        val contact = "88"+num // use country code with your phone number
        val url = "https://api.whatsapp.com/send?phone=$contact"
        try {
            val pm = context!!.packageManager
            pm.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(activity, "WhatsApp app not installed in your phone", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }

    }

}
