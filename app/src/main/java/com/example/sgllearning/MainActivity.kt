package com.example.sgllearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


                try{

                    val myDatabase = this.openOrCreateDatabase("Musicians", Context.MODE_PRIVATE, null)

                    myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY, name VARCHAR, age INT)")

                    //myDatabase.execSQL("INSERT INTO musicians (name,age) VALUES ('james',5)")

                    myDatabase.execSQL("UPDATE musicians SET age = 61 WHERE name = 'james'")  //james'in yaşını 61 yap
                    //val cursor = myDatabase.rawQuery("SELECT * FROM musicians WHERE name LIKE 'L%'", null)  //LIKE %s sonu s ile biten, k% k ile başlayan
                    myDatabase.execSQL("UPDATE musicians SET name = 'Kirk Hamett' WHERE id = 2")

                    myDatabase.execSQL("DELETE FROM musicians WHERE name = 'lars'")

                    val cursor = myDatabase.rawQuery("SELECT * FROM musicians", null)

                    val nameIx = cursor.getColumnIndex("name")
                    val ageIx = cursor.getColumnIndex("age")
                    val idIx = cursor.getColumnIndex("id")
//                    val idIx = cursor.getColumnIndex("id")

                    while(cursor.moveToNext()){

                        println("Name: " + cursor.getString(nameIx))
                        println("Age: " + cursor.getInt(ageIx))
                        println("Id: " + cursor.getInt(idIx))
                    }
                    cursor.close()

                }catch(e: Exception){
                    e.printStackTrace()
                }
            }
        }