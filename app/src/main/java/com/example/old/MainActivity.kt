package com.example.old

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var bt1: ImageView
    lateinit var bt2: ImageView
    lateinit var bt3: ImageView
    lateinit var bt4: ImageView
    lateinit var bt5: ImageView
    lateinit var bt6: ImageView
    lateinit var bt7: ImageView
    lateinit var bt8: ImageView
    lateinit var bt9: ImageView
    lateinit var jogadorTxt: TextView
    lateinit var btReset: Button
    var jogador = true
    var fimRodada = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciaPartida()
        btReset = findViewById(R.id.btReset)
        btReset.setOnClickListener {
            chamaReset()
        }

    }


    fun iniciaPartida() {
        jogadorTxt = findViewById(R.id.cxText2)
        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)
        bt6 = findViewById(R.id.bt6)
        bt7 = findViewById(R.id.bt7)
        bt8 = findViewById(R.id.bt8)
        bt9 = findViewById(R.id.bt9)

        printaBotao(bt1)
        printaBotao(bt2)
        printaBotao(bt3)
        printaBotao(bt4)
        printaBotao(bt5)
        printaBotao(bt6)
        printaBotao(bt7)
        printaBotao(bt8)
        printaBotao(bt9)
    }

    fun printaBotao(box: ImageView) {
        jogadorTxt.text = "Player 1"
        box.setOnClickListener {
            if (box.tag == null && !fimRodada) {
                if (jogador) {
                    box.setImageResource(R.drawable.bola_blue)
                    jogador = false
                    box.tag = 1
                    jogadorTxt.text = "Player 2"
                } else {
                    box.setImageResource(R.drawable.xiz)
                    jogador = true
                    box.tag = 2
                    jogadorTxt.text = "Player 1"
                }
                if (ganhador(1)) {
                    jogadorTxt.text = "Player 1 WIN!!!"
                    fimRodada = true

                } else if (ganhador(2)) {
                    jogadorTxt.text = "Player 2 WIN!!!"
                    fimRodada = true


                }
            }

        }
    }

    fun ganhador(velha: Int): Boolean {//colunas

        //diagonal principal

        //diagonal secundária

        //linhas
        return ((bt1.tag == velha && bt2.tag == velha && bt3.tag == velha)
                || (bt4.tag == velha && bt5.tag == velha && bt6.tag == velha)
                || (bt7.tag == velha && bt8.tag == velha && bt9.tag == velha)

                //colunas
                || (bt1.tag == velha && bt4.tag == velha && bt7.tag == velha)
                || (bt2.tag == velha && bt5.tag == velha && bt8.tag == velha)
                || (bt3.tag == velha && bt6.tag == velha && bt9.tag == velha)

                //diagonal principal
                || (bt1.tag == velha && bt5.tag == velha && bt9.tag == velha)

                //diagonal secundária
                || (bt3.tag == velha && bt5.tag == velha && bt7.tag == velha))
    }

    fun reset(box: ImageView) {
        box.setImageDrawable(null)
        box.tag = null
        fimRodada = false
        jogador = true
        iniciaPartida()
    }

    fun chamaReset() {
        reset(bt1)
        reset(bt2)
        reset(bt3)
        reset(bt4)
        reset(bt5)
        reset(bt6)
        reset(bt7)
        reset(bt8)
        reset(bt9)
        jogadorTxt.text = ""
    }

}