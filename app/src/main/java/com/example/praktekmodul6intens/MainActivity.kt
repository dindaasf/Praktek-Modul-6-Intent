package com.example.praktekmodul6intens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val testData = createPhoneData()
        rv_parts.layoutManager = LinearLayoutManager(this )
        rv_parts.setHasFixedSize(true)
        rv_parts.adapter = ContactAdapter(testData,{phoneItem : PhoneData -> phoneItemClicked(phoneItem) })
    }
    private fun phoneItemClicked(phoneItem : PhoneData){
        val showDetailActivityIntent= Intent(this, PhoneDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, phoneItem.phone.toString())
        showDetailActivityIntent.putExtra(Intent.EXTRA_COMPONENT_NAME, phoneItem.email)
        startActivity(showDetailActivityIntent)
    }

    private fun createPhoneData(): List<PhoneData> {
        val partList = ArrayList<PhoneData>()
        partList.add(PhoneData(9864944, "Alpha", "alpha@gmail.com"))
        partList.add(PhoneData(1345367, "Bravo", "bravo@gmail.com"))
        partList.add(PhoneData(1457893, "Charlie", "charli@gmail.com"))
        return partList
    }
}
