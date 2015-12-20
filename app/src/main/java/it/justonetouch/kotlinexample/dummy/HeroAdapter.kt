package it.justonetouch.kotlinexample.dummy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import it.justonetouch.kotlinexample.R
import kotlinx.android.synthetic.main.item_hero.*

/**
 * [RecyclerView.Adapter] that can display a [HeroItem] and makes a call to the
 * specified [HeroOnClickListener].
 */
class HeroAdapter(private val mValues: List<HeroItem>, private val mListener: Function1<HeroItem, Unit>?) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = mValues[position]
        holder.item = hero
        holder.nameView.text = "${hero.name} (Power: ${hero.power})"
        holder.genderView.text = hero.gender
        holder.eyesView.text = hero.eyes
        holder.hairView.text = hero.hair
        holder.eyesView.visibility = if (hero.eyes != null) 1 else 0;
        holder.hairView.visibility = if (hero.hair != null) 1 else 0;

        holder.itemView.setOnClickListener {
            mListener?.invoke(hero)
        }
    }

    override fun getItemCount() = mValues.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView        // Property READ-ONLY (val)
        val genderView: TextView   // Property READ-ONLY (val)
        val eyesView : TextView
        val hairView: TextView
        var item: HeroItem? = null  // Property READ-WRITE (var) and nullable (?)

        init {
            nameView = view.findViewById(R.id.name) as TextView
            genderView = view.findViewById(R.id.gender) as TextView
            eyesView = view.findViewById(R.id.eyes) as TextView
            hairView = view.findViewById(R.id.hair) as TextView
        }
    }
}
