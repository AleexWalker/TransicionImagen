package com.example.transicionimagen.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.transicionimagen.CardAdapter
import com.example.transicionimagen.R
import com.example.transicionimagen.Tarjeta
import com.example.transicionimagen.databinding.FragmentGalleryBinding
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.util.ArrayList

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler : RecyclerView = recyclerItems

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre1)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre2)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre3)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre4)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre5)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre6)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre7)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre8)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre9)))
        items.add(Tarjeta(R.drawable.ic_mail, resources.getString(R.string.nombre10)))

        recycler.setHasFixedSize(true)
        recycler.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))

        val adaptador = CardAdapter(items)
        recycler.adapter = adaptador
        recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}