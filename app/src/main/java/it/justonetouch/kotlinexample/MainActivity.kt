package it.justonetouch.kotlinexample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import it.justonetouch.kotlinexample.dummy.HeroAdapter
import it.justonetouch.kotlinexample.dummy.HeroDummyContent
import it.justonetouch.kotlinexample.dummy.HeroItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_hero.*

class MainActivity : AppCompatActivity() {

    private var currentHero: HeroItem? = null

    private val adapter by lazy {
        HeroAdapter(HeroDummyContent.ITEMS) {
            val previousHero = currentHero
            if (previousHero != null) {
                if (previousHero.gender.equals(it.gender)) {
                    // fight
                    val conclusion = if (previousHero.power == it.power) {
                        "It's a draw"
                    } else if (previousHero.power > it.power) {
                        "${previousHero.name} wins!"
                    } else {
                        "${it.name} wins!"
                    }
                    Snackbar.make(fab, "${previousHero.name} vs ${it.name}!\n$conclusion", Snackbar.LENGTH_LONG).show()
                } else {
                    val newGender = if (Math.random() > 0.5) previousHero.gender else it.gender
                    val newEyes = if (Math.random() > 0.5) previousHero.eyes else it.eyes;
                    val newHair = if (Math.random() > 0.5) previousHero.hair else it.hair;
                    val newName = (if (newGender.equals(previousHero.gender)) previousHero.name else it.name) + " junior";
                    val newPower = if (Math.random() > 0.5) previousHero.power else it.power;
                    val newHero = HeroItem(newName, newGender, newPower, newHair?:"red", newEyes?:"black")
                    HeroDummyContent.ITEMS.add(newHero)
                    Snackbar.make(fab, "${previousHero.name} and ${it.name} just made a baby!", Snackbar.LENGTH_LONG).show()

                }
                currentHero = null
            } else {
                // assign current hero
                Snackbar.make(fab, "Choose: ${it.name}", Snackbar.LENGTH_SHORT).show()
                currentHero = it
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { Snackbar.make(it, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Snackbar.make(fab, "Choose: Menu > Settings", Snackbar.LENGTH_SHORT).show()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
