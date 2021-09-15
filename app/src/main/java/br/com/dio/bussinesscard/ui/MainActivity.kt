package br.com.dio.bussinesscard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import br.com.dio.bussinesscard.AddBusinessCardActivity
import br.com.dio.bussinesscard.App
import br.com.dio.bussinesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private  val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListerner()


    }
    private fun insertListerner(){
        binding.floatingAdd.setOnClickListener {
            val intent = Intent(this@MainActivity,AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
            br.com.dio.bussinesscard.util.Image.share(this@MainActivity,card)
        }

    }

    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this) { businessCards ->
            adapter.submitList(businessCards)
        }

    }
}