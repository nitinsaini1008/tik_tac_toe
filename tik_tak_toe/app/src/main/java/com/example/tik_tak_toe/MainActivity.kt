package com.example.tik_tak_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun bclick(view:View){
        val bselected=view as Button
        var b_id=0
        when(bselected.id){
            R.id.b1 -> b_id=1
            R.id.b2 -> b_id=2
            R.id.b3 -> b_id=3
            R.id.b4 -> b_id=4
            R.id.b5 -> b_id=5
            R.id.b6 -> b_id=6
            R.id.b7 -> b_id=7
            R.id.b8 -> b_id=8
            R.id.b9 -> b_id=9
        }

        playgame(b_id,bselected)
    }
    var p1=ArrayList<Int>()
    var p2=ArrayList<Int>()

    var active_player=1

   private fun playgame(b_id:Int,bselected:Button){
       if(active_player==1){
           bselected.text="X"
           bselected.setBackgroundColor(Color.parseColor("#00FF00"))
           active_player=2
           p1.add(b_id)
       }
       else{
           bselected.text="O"
           active_player=1
           bselected.setBackgroundColor(Color.parseColor("#006400"))
           p2.add(b_id)
       }
       bselected.isEnabled=false
       winner()
       
   }
    private fun winner(){
        var win=-1
        if(p1.contains(1) && p1.contains(2) && p1.contains(3)){
            win=1
        }
        if(p2.contains(1) && p2.contains(2) && p2.contains(3)){
            win=2
        }
        if(p1.contains(4) && p1.contains(5) && p1.contains(6)){
            win=1
        }
        if(p2.contains(4) && p2.contains(5) && p2.contains(6)){
            win=2
        }
        if(p1.contains(7) && p1.contains(8) && p1.contains(9)){
            win=1
        }
        if(p2.contains(7) && p2.contains(8) && p2.contains(9)){
            win=2
        }
        if(p1.contains(1) && p1.contains(4) && p1.contains(7)){
            win=1
        }
        if(p2.contains(1) && p2.contains(4) && p2.contains(7)){
            win=2
        }
        if(p1.contains(2) && p1.contains(5) && p1.contains(8)){
            win=1
        }
        if(p2.contains(2) && p2.contains(5) && p2.contains(8)){
            win=2
        }
        if(p1.contains(3) && p1.contains(6) && p1.contains(9)){
            win=1
        }
        if(p2.contains(3) && p2.contains(6) && p2.contains(9)){
            win=2
        }
        if(p1.contains(1) && p1.contains(5) && p1.contains(9)){
            win=1
        }
        if(p2.contains(1) && p2.contains(5) && p2.contains(9)){
            win=2
        }
        if(p1.contains(3) && p1.contains(5) && p1.contains(7)){
            win=1
        }
        if(p2.contains(3) && p2.contains(5) && p2.contains(7)){
            win=2
        }
        if(win!=-1){
            if(win==1){
                Toast.makeText(this,"player 1 is winner",Toast.LENGTH_LONG).show()
            }
            if(win==2){
                Toast.makeText(this,"player 2 is winner",Toast.LENGTH_LONG).show()
            }
        }
    }
}