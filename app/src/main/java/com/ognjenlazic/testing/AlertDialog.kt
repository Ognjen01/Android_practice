package com.ognjenlazic.testing

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_alert_dialog.*


class AlertDialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        val addCOntactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do yo want to add person to contact list")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") {
                _, _ ->
                Toast.makeText(this, "You added person!", Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("No") {
                _, _ ->
                Toast.makeText(this, "You canceled", Toast.LENGTH_SHORT).show()
            }.create()

        dialog1.setOnClickListener {
            addCOntactDialog.show()
        }



        val options = arrayOf("FIrst", "Second", "Third")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose options")
            .setSingleChoiceItems(options, 0 ) {
                dialogInterface, i ->

                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()}

            .setPositiveButton("Accept") {
                    _, _ ->
                Toast.makeText(this, "You accepted!", Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("Decline"){
                    _, _ ->
                Toast.makeText(this, "You declined", Toast.LENGTH_SHORT).show()
            }.create()

        dialog2.setOnClickListener {
            singleChoiceDialog.show()
        }





        val multichoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)){
                _, i, isChecked ->
                if (isChecked){
                Toast.makeText(this, "You checked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "You unchecked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            }
            .setPositiveButton("Accept") {
                    _, _ ->
                Toast.makeText(this, "You accepted!", Toast.LENGTH_SHORT).show()
            }

            .setNegativeButton("Decline"){
                    _, _ ->
                Toast.makeText(this, "You declined", Toast.LENGTH_SHORT).show()
            }.create()

        dialog3.setOnClickListener {
            multichoiceDialog.show()
        }





    }
}
