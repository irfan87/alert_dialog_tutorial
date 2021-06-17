package com.irfanshukri203.alertdialogtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // general alert dialog
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add contact")
            .setMessage("Do you want to add this user as your new contact?")
            .setIcon(R.drawable.ic_add_contact_foreground)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "This user have been saved in your contact list", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Cancel") { _, _ ->
                Toast.makeText(this, "Unable to save this user in your contact list", Toast.LENGTH_LONG).show()
            }.create()

        btnAlert1.setOnClickListener {
            addContactDialog.show()
        }

        // alert dialog that contained options
        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceOptionDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of this options")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_LONG).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You have accepted one of the item from your choice dialog", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You choice dialog was declined by you", Toast.LENGTH_LONG).show()
            }.create()

        btnAlert2.setOnClickListener {
            singleChoiceOptionDialog.show()
        }

        // alert dialog that contained multi options
        val multiChoiceOptionsDialog = AlertDialog.Builder(this)
            .setTitle("Choose as many options that you want")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { _, i, isChecked ->
                if(isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_LONG).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "The selected item have been saved in your memory", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You multi choice dialog was declined by you", Toast.LENGTH_LONG).show()
            }.create()

        btnAlert3.setOnClickListener {
            multiChoiceOptionsDialog.show()
        }
    }
}