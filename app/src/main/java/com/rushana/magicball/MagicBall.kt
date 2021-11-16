package com.rushana.magicball

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

private const val LAST_RANDOM_VALUE = "LAST_RANDOM_VALUE"

class MagicBall : Fragment() {

    private lateinit var randomBall: ImageView

    private var randomValue: Boolean = true


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_magic_ball, container, false)
        randomBall = view.findViewById(R.id.random_ball)
        savedInstanceState?.let { randomValue = it.getBoolean(LAST_RANDOM_VALUE) }
        shakeBall(randomValue)


        // Inflate the layout for this fragment

        randomBall.setOnClickListener {
            randomValue = Random.nextBoolean()
            shakeBall(randomValue)
        }



        return view
    }

    private fun shakeBall(randomValue: Boolean){
            randomBall.setImageResource(
                when (randomValue){
                    true -> R.drawable.ball_yas
                    false -> R.drawable.ball_no

                }
            )

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(LAST_RANDOM_VALUE, randomValue)
    }

    companion object {

        @JvmStatic
        fun newInstance() = MagicBall()}
                }

