package com.daffodil.varsity.aupf.ui.fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.daffodil.varsity.aupf.R
import com.daffodil.varsity.aupf.model.ContactAdmin

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
                R.drawable.nazim1,
                "Mr. Najim Uddin Sharker",
                "Deputy Director (P&D)",
                "najim@daffodilvarsity.edu.bd",
                "Cell: +8801713493040, " +
                        "Daffodil Tower\n" +
                        "Assigned for- Venue Decoration\n")
        )
        listOfContact.add(ContactAdmin(
                R.drawable.mizi,
                "Mr. Md. Ishaque Mijee",
                "Deputy Registrar",
                "ishaque@daffodilvarsity.edu.bd",
                "Cell: +8801811458872\n" +
                        " Permanent Campus\n" +
                        "Assigned for- Venue Decoration & Overall Coordination")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.moslehuddin,
                "Mr. Md. Moslehuddin Chowdhury\n",
                "Deputy Director (P&D)",
                "moslehuddin@daffodilvarsity.edu.bd\n",
                "Cell: +01847140131\n" +
                        "Permanent Campus\n" +
                        "Assigned for- Venue Decoration & Food\n")
        )
        listOfContact.add(ContactAdmin(
                R.drawable.arman,
                "Major Md. Arman Ali Bhuiyan (Retd)\n",
                "Project Director, Development",
                "arman.pd@daffodilvarsity.edu.bd",
                "Cell: +8801847140099\n" +
                        "Permanent Campus\n" +
                        "Assigned for- Power Management & Support")
        )
        listOfContact.add(ContactAdmin(
                R.drawable.admin_avatar_ansary,
                "Mr. Ahemed Shamim Ansary\n",
                "Senior Assistant Director & SA to Chairman, BoT",
                "ps.chairman@daffodilvarsity.edu.bd",
                "Cell: +8801713493087   Ext: 223\n" +
                        "Daffodil Tower-04 (Main Campus)\n" +
                        "Assigned for- Overall Coordination\n")
        )
        listOfContact.add(ContactAdmin(
                R.drawable.diljeb_kabir_n,
                "Mr. Kazi Md. Diljeb Kabir",
                "Senior Assistant Director",
                "diljeb@daffodilvarsity.edu.bd",
                "diljeb@daffodilvarsity.edu.bd\n" +
                        "Cell: +8801713493104\n" +
                        "Permanent Campus\n" +
                        "Assigned for- Transport & Overall Coordination"
        )
        )
        listOfContact.add(ContactAdmin(
                R.drawable.awal,
                "Mr. Md. Abdul Awal\n",
                "Senior Assistant Registrar",
                "abdulawal@daffodilvarsity.edu.bd",
                "Cell: +8801811458807   Ext: 380\n" +
                        "Daffodil Tower\n" +
                        "Assigned for- Food\n")
        )
        listOfContact.add(ContactAdmin(
                R.drawable.raiyan,
                "Mr. Raiyan Mustafa",
                "Senior Assistant Director (IT)",
                "raiyan.it@daffodilvarsity.edu.bd",
                "Cell: +8801713493056   Ext: 199\n" +
                        "Main Campus\n" +
                        "Assigned for- IT Support")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.farhad_alam_n,
                "Mr. Md. Farhad Alam",
                "Administrative Officer (Office of the Provc & Dean, FSIT)",
                "provcoffice@daffodilvarsity.edu.bd",
                "Cell: +8801847334770   Ext: 232\n" +
                        "Main Campus\n" +
                        "Assigned for- Email Circulation")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.habib,
                "Md. Habibur Rahman",
                "Assistant Officer",
                "habibur@daffodilvarsity.edu.bd",
                "Cell: +8801847140060   Ext: 140\n" +
                        "Daffodil Tower-04 (Main Campus)\n" +
                        "Assigned for- Budget & Overall Coordination")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.miraz,
                "Mr. Md. Mirazul Islam",
                "Asst. Admin officer",
                "miraz.a@daffodilvarsity.edu.bd",
                "Cell: +8801811458897   Ext: 105\n" +
                        "Daffodil Tower-04\n" +
                        "Assigned for- Overall Coordination")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.admin_umam,
                "Mr. Md. Umam Mustain",
                "Asst. Admin officer",
                "umam@daffodilvarsity.edu.bd",
                "Cell: +8801811458897   Ext: 113\n" +
                        "Daffodil Tower-04\n" +
                        "Assigned for- Volunteer, Communication & Overall Coordination\n" +
                        "\n")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.zisan,
                "Ms. Zisan Imam\n",
                "Assistant Administrative officer",
                "rar@daffodilvarsity.edu.bd",
                "Cell: +8801847-334817  Ext: 223\n" +
                        "Main Campus, Daffodil Tower-04\n" +
                        "Assigned for- Volunteer, Communication & Overall Coordination")
        )

        listOfContact.add(ContactAdmin(
                R.drawable.sabuj,
                "Mr. Md. Tarekol Islam Sobuj\n",
                "Assistant Administrative officer",
                "cmoffice@daffodilvarsity.edu.bd",
                "Cell: +8801847-140059   Ext: 109\n" +
                        "Main Campus, Daffodil Tower-04\n" +
                        "Assigned for- Transport")
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
        }

        inner class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val avatar: ImageView = itemView.findViewById(R.id.admin_avatar)!!
            val name = itemView.findViewById<TextView>(R.id.name_of_admin)!!
            val designation = itemView.findViewById<TextView>(R.id.designation_of_admin)!!
            val mail = itemView.findViewById<TextView>(R.id.mail_of_admin)!!
            val cell = itemView.findViewById<TextView>(R.id.cell_of_admin)!!
        }

    }

}
