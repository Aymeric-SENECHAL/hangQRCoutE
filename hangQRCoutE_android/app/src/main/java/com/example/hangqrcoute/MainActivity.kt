package com.example.hangqrcoute

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hangqrcoute.databinding.ActivityBottomNavigationBinding
import com.example.tp1.WebServiceInterface
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, OnListClickListener {

    private lateinit var binding : ActivityBottomNavigationBinding

    private val mainFragment = MainFragment()
    private val secondFragment = SecondFragment("", "")
    private val listFragment = ListFragment(this)
    private val inventoryFragment = InventoryFragment("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationBinding.inflate(layoutInflater)

        binding.idBottomNavigationView.setOnNavigationItemSelectedListener(this)

        loadFragment(mainFragment)

        setContentView(binding.root)
    }

    private fun loadFragment(fragment : Fragment?) : Boolean{
        if(fragment != null ){
            supportFragmentManager.beginTransaction().replace(R.id.idFrameLayout, fragment).commit()

            return true
        }
        return false
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_home){
            return loadFragment(mainFragment)
        }
        if(item.itemId == R.id.action_inventory){
            return loadFragment(listFragment)
        }
        return false
    }

    fun generateQrCode(view: View){
        if(
            binding.idPlainTextName.text.toString().trim().length > 0 &&
            binding.idPlainTextURL.text.toString().trim().length > 0) {
            supportFragmentManager.beginTransaction().replace(
                R.id.idFrameLayout, InventoryFragment(
                    binding.idPlainTextName.text.toString(),
                    binding.idPlainTextURL.text.toString()
                )
            ).commit()
        }else{
            Toast.makeText(this@MainActivity, "Les champs ne doivent pas être vide !", Toast.LENGTH_SHORT).show();
        }
    }

    fun postQrCode(view: View){
        val retrofit = Retrofit.Builder().baseUrl("http://10.0.2.2:8080/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val ws = retrofit.create(WebServiceInterface::class.java)

        var qrCode: QrCode = QrCode(
            binding.idPlainTextName.text.trim().toString(),
            binding.idPlainTextURL.text.trim().toString()
        )

        val callPostQrCode = ws.postQrCode(qrCode)

        callPostQrCode.enqueue(object : Callback<QrCode> {
            override fun onResponse(call: Call<QrCode>, response: Response<QrCode>) {
                Toast.makeText(this@MainActivity, "Bien ajouté !", Toast.LENGTH_SHORT).show();
                binding.idPlainTextName.setText("")
                binding.idPlainTextURL.setText("")
            }

            override fun onFailure(call: Call<QrCode>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Une erreur est apparue !", Toast.LENGTH_SHORT).show();
                println("Fail")
                println(t.message)
            }
        })
    }

    override fun clickOnQrCode(qrCode: QrCode) {
        var secondFragmentToLoad = SecondFragment(qrCode.name_qrCode, qrCode.url_qrCode)
        loadFragment(secondFragmentToLoad)
    }

}