package com.example.ejemplo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), TextWatcher {
    private var editNameZone: EditText? = null
    private var editCodeZone: EditText? = null
    private var textNameZone: TextView? = null
    private var textCodeZone: TextView? = null
    private var namezone: String? = null
    private var codezone: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNameZone = findViewById(R.id.txtNombreZona_NameZone) as EditText
        editCodeZone = findViewById(R.id.txtCodigoZona_ZoneCode) as EditText
        textNameZone = findViewById(R.id.textView_NameZone) as TextView
        textCodeZone = findViewById(R.id.textView_CodeZone) as TextView
        editNameZone!!.addTextChangedListener(this)
        editCodeZone!!.addTextChangedListener(this)


    }

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //Toast.makeText(this,s.toString(),Toast.LENGTH_SHORT).show()
        namezone = editNameZone?.text.toString()
        //codezone = Integer.valueOf(editCodeZone?.text.toString())
        codezone = editCodeZone?.text.toString()
        if (namezone != "")textNameZone?.text = namezone
        if(codezone != "")textCodeZone?.text = codezone
    }
}
