package com.daffodil.varsity.aupf.ui.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daffodil.varsity.aupf.R
import room.database.volunteer.Volunteer
import room.database.volunteer.VolunteerAdapter
import room.database.volunteer.VolunteerViewModel


/*
* this is the volunteer fragment. where the list of volunteers are shown on a recycler view.
* */

class Volunteer : Fragment() {

    private lateinit var volunteerViewModel: VolunteerViewModel
    private var volunteerAdapter: VolunteerAdapter = VolunteerAdapter()
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_volunteer, container, false)

        volunteerViewModel = ViewModelProviders.of(this).get(VolunteerViewModel::class.java)
        volunteerViewModel.deleteAllVolunteers() //all volunteers are deleted from room

        volunteerViewModel.allVolunteers.observe(this, Observer {
            volunteerAdapter.submitList(it)
            recyclerView = view.findViewById(R.id.recycler_view)
//
//            if (it.size == 0)
//                insert()

//            recyclerView.apply {
//                hasFixedSize()
//                layoutManager = LinearLayoutManager(context)
//                adapter = volunteerAdapter
//            }
        })

        volunteerAdapter.setOnItemClickListener {

            val builder = context?.let {
                AlertDialog.Builder(it)
            }

            builder?.setTitle(it.volunteerName)
            // Display a message on alert dialog
            builder?.setMessage("Want to call to ${it.mobileNumber} this number?")

            // Set a positive button and its click listener on alert dialog
            builder?.setPositiveButton("Call") { dialog, _ ->
                dialog.cancel()

                try {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:${it.mobileNumber.trim()}")
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            // Display a neutral button on alert dialog
            builder?.setNeutralButton("Cancel") { dialog, _ -> dialog.cancel() }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder?.create()!!

            // Display the alert dialog on app interface
            dialog.show()
        }

        return view
    }

    private fun insert() {

        val name = arrayOf("Md. Omar Faruk",
                "Towhidul Islam",
                "K. M. Mohiuddin",
                "Md.Imtiaj Sultan Tanvir",
                "Md. Masud Rana",
                "Md. Assamiul Momith Fahim",
                "Meher Durdana Khan Raisa",
                "Md Rezaul Tanvir Tuhin",
                "Muhsinat Binta Murtaza",
                "MD. Mainul Hasan",
                "Mahadi Hassan",
                "Hasnur Jahan",
                "Minhaj Hossain",
                "Sabina Yesmin Anika",
                "Moumita Goswami",
                "Partha Protim Ghose",
                "Amir ahmed",
                "Md.Forhad Ali",
                "Golam Mohiuddin Niloy",
                "Ashik Mahmood",
                "Tanha Akter Mitu",
                "Md.Shakil Hossain",
                "Abir Hosen",
                "Laboni Akther Prity",
                "MD. RAMJUN ALI",
                "Zarin Maiesha",
                "MD. MUHTASIM ISLAM",
                "Md. Naim",
                "Ankor Saha Dip",
                "Arofa Ratri",
                "Md.Imtiaj Sultan Tanvir")

        val phone = arrayOf("" +
                "01736648160",
                "01521733203",
                "01818336022",
                "01866371480",
                "01930041294",
                "01533181289",
                "01552348834",
                "01740632787",
                "01722498473",
                "01860202896",
                "01701093027",
                "01838638487",
                "01517176553",
                "01718225783",
                "01960487758",
                "01716712960",
                "01834085818",
                "01773221242",
                "01680990755",
                "01317424004",
                "01646439990",
                "01861767365",
                "01728500736",
                "01783872059",
                "01717546314",
                "01768316227",
                "01717423223",
                " ",
                "01931994304",
                "01985270407",
                "01866371480")

        val mail = arrayOf(
                "omar15-1906@diu.edu.bd",
                "towhidul15-12728@diu.edu.bd",
                "mohiuddin35-2894@diu.edu.bd",
                "imtiaj15-1954@diu.edu.bd",
                "masud11-5156@diu.edu.bd",
                "assamiul15-11311@diu.edu.bd",
                "meher35-2818@diu.edu.bd",
                "rezaul15-1981@diu.edu.bd",
                "muhsinat34-938@diu.edu.bd",
                "mainul35-2339@diu.edu.bd",
                "mahadi15-1955@diu.edu.bd",
                "hasnur35-2297@diu.edu.bd",
                "minhaj34-876@diu.edu.bd",
                "sabina35-2406@diu.edu.bd",
                "moumita35-2298@diu.edu.bd",
                "partha35-2350@diu.edu.bd",
                "amir15-8178@diu.edu.bd",
                "forhad33-3624@diu.edu.bd",
                "golam35-2845@diu.edu.bd",
                "ashik15-12060@diu.edu.bd",
                "tanha35-2812@diu.edu.bd",
                "shakil33-4563@diu.edu.bd",
                "abir35-2834@diu.edu.bd",
                "Laboni35-2892@diu.edu.bd",
                "ramjun23-704@diu.edu.bd",
                "zarin23-708@diu.edu.bd",
                "muhtasin23-706@diu.edu.bd",
                "naim23-711@diu.edu.bd",
                "ankor23-700@diu.edu.bd",
                "arofa29-821@diu.edu.bd",
                "imtiaj15-1954@diu.edu.bd")

        val studentId = arrayOf(
                "181-15-1906\n",
                "191-15-12728\n",
                "192-35-2894\n",
                "181-15-1954\n",
                "162-11-5156\n",
                "181-15-11311\n",
                "192-35-2818\n",
                "181-15-1981\n",
                "191-34-938\n",
                "181-35-2339\n",
                "181-15-1955\n",
                "181-35-2297\n",
                "191-34-876\n",
                "181-35-2406\n",
                "181-35-2298\n",
                "181-35-2350\n",
                "162-15-8178\n",
                "163-33-3624\n",
                "192-35-2845\n",
                "191-15-12060\n",
                "192-35-2812\n",
                "181-33-4563\n",
                "192-35-2834\n",
                "192-35-2892\n",
                "192-23-704\n",
                "192-23-708\n",
                "192-23-706\n",
                "192-23-711\n",
                "192-23-700\n",
                "193-46-278\n",
                "181-15-1954\n")

        val campus = arrayOf(
                "PC\n",
                "MC\n",
                "MC\n",
                "PC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "PC\n",
                "MC\n",
                "MC\n",
                "PC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "MC\n",
                "PC\n",
                "PC\n",
                "PC\n",
                "PC\n",
                "PC\n",
                "MC\n",
                "PC\n")

        val dept = arrayOf(
                "CSE\n",
                "CSE\n",
                "SWE\n",
                "CSE\n",
                "DBA\n",
                "CSE\n",
                "SWE\n",
                "CSE\n",
                "NFE\n",
                "SWE\n",
                "CSE\n",
                "SWE\n",
                "NFE\n",
                "SWE\n",
                "SWE\n",
                "SWE\n",
                "CSE\n",
                "EEE\n",
                "SWE\n",
                "CSE\n",
                "SWE\n",
                "EEE\n",
                "SWE\n",
                "SWE\n",
                "TE\n",
                "TE\n",
                "TE\n",
                "TE\n",
                "TE\n",
                "Phar\n",
                "CSE\n")

        for (i in name.indices) {
            volunteerViewModel.insert(Volunteer(name[i],
                    dept[i].trim(),
                    campus[i].trim(),
                    studentId[i].trim(),
                    mail[i],
                    phone[i])
            )
        }
    }
}
