package com.rushana.magicball

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rushana.magicball.databinding.ActivityMainBinding as ActivityMainBinding1


class MainActivity : AppCompatActivity() {
//объявляем binding для упрощения обращения к элементам
    lateinit var binding: ActivityMainBinding1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //инициализируем binding
        binding = ActivityMainBinding1.inflate(layoutInflater)

        setContentView(binding.root)

        //вешаем слушатель нажатия на кнопку "О программе"
        binding.aboutButton.setOnClickListener{
            //открываем фрагмент "о программе"
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.plase_fragment, About.newInstance())
                .commit()
        }

        //вешаем слушатель нажатия на кнопку "Начать"
        binding.startButton.setOnClickListener {
            //запускаем фрагмент Magic ball
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.plase_fragment, MagicBall.newInstance())
                .commit()

        }

        val humanList: List<Human> = listOf(
            Human("Преподаватель", "Новопашенный Максим Витальевич"),
            Human("Разработчик", "Белякова Рушания Рустамовна")
        )

        val recyclerViewHuman: RecyclerView=findViewById(R.id.recycler_human)
        recyclerViewHuman.layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewHuman.addItemDecoration(DividerItemDecoration(
            this,
            DividerItemDecoration.VERTICAL
        )
        )
        recyclerViewHuman.adapter = HumanAdapter(humanList)

        val siteButton: Button = findViewById(R.id.site_button)
        val link = Uri.parse ("https://odin.study/")
        val intent = Intent(Intent.ACTION_VIEW, link)

        siteButton.setOnClickListener {startActivity(intent)}





















    }

}

