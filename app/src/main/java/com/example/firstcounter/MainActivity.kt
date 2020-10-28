package com.example.firstcounter

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.fragment_counter.*


class MainActivity : AppCompatActivity() {
    private var counterFragment = CounterFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_layout, counterFragment).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.reset_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.reset_menu -> {
                number_txt.setText("0")
                return true
            }
            R.id.edit_menu->{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Edit Counter")
                alertDialogBuilder.setMessage("Title")
                alertDialogBuilder.setMessage("Value")
                alertDialogBuilder.show()
                return true
            }
            R.id.setting_menu->{
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}