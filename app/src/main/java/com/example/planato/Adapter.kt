package com.example.planato

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import java.util.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {
    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title

        //        val planetimg = view.planet_img
        val galaxy = view.galaxy
        val distance = view.distance
        val gravity = view.gravity
        val planetimg: ImageView = view.findViewById(R.id.planat_img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val iteamView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return myViewHolder(iteamView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener {val intent = Intent(holder.itemView.context,PlanetDetail::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("planetImage",dummyImage)
        holder.itemView.context.startActivity(intent)}
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + "m km"
        holder.gravity.text = planet[position].gravity + "m/ss"

        when (planet[position].title!!.lowercase(Locale.getDefault())) {
            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }
            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }
            "moon" -> {
                dummyImage = R.drawable.ic_moon
            }
            "venus" -> {
                dummyImage = R.drawable.ic_venus
            }
            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }
            "saturn" -> {
                dummyImage = R.drawable.ic_saturn
            }
            "urenus" -> {
                dummyImage = R.drawable.ic_uranus
            }
            "mercury" -> {
                dummyImage = R.drawable.ic_mercury
            }
            "sun" -> {
                dummyImage = R.drawable.ic_sun
            }
            "earth" -> {
                dummyImage = R.drawable.ic_earth
            }
        }
        if (dummyImage != null) {
            holder.planetimg.setImageResource(dummyImage)
        }


    }

    override fun getItemCount(): Int {
        return planet.size
    }
}

