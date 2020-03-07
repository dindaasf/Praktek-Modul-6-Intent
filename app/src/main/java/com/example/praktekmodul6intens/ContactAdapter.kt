package com.example.praktekmodul6intens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_list_item.view.*
//class adapter sendiri berfungsi untuk menerapkan multipleview pada recyclerview, karena rv itu cuman biasa nampilin satu baris. dan pada adapter ini kita mengatur data yang akan ditampilkan dalam view
class ContactAdapter (val phoneItemList: List<PhoneData>, val clickListener:(PhoneData) -> Unit ) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    //phoneitemlist sendiri merupakan construktor data. list<phonedata> karena yang akan dimasukkan pada recycler view itu yg disimpen di phonedata
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view = inflater.inflate(R.layout.contact_list_item, parent, false)
            return PartViewHolder(view)
        //vieholder berfungsi agar kita tidak salah menampilkan pada recyclerview
        }
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
            (holder as PartViewHolder).bind(phoneItemList[position], clickListener)
        }
        override fun getItemCount() = phoneItemList.size

        class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(phone: PhoneData, clickListener: (PhoneData) -> Unit) {
                itemView.tv_part_item_name.text = phone.contactName
                itemView.tv_part_id.text = phone.phone.toString()
                itemView.email.text=phone.email
                itemView.setOnClickListener{clickListener(phone)}

            }
        }
    }
