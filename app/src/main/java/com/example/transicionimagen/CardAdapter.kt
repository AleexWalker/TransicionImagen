package com.example.transicionimagen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private var items: ArrayList<Tarjeta>) : RecyclerView.Adapter<CardAdapter.TarjViewHolder>() {

    private var onClick: (View) -> Unit

    init {
        this.items = items
        onClick = {}
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var imagen : ImageFilterView = itemView.findViewById(R.id.imagenCard)
        private var texto : TextView = itemView.findViewById(R.id.textoCard)

        fun bindTarjeta(t: Tarjeta, onClick: (View) -> Unit) = with(itemView) {
            imagen.setImageResource(t.imageFV)
            texto.text = t.nombre
            setOnClickListener{ onClick(itemView) }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item,onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}