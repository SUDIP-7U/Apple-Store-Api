package com.example.apple.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apple.adapter.ListAdapter
import com.example.apple.databinding.FragmentProductBinding
import com.example.apple.utils.BaseFragment
import com.example.apple.viewmodel.MainViewModel

class ProductFragment : BaseFragment<FragmentProductBinding>(FragmentProductBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    lateinit var productlist : ListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllProduct()
        viewModel.allProductResponse.observe(requireActivity()) { response ->
            productlist = ListAdapter(response.products)
            val manager = GridLayoutManager(requireContext(), 2)
            binding.rcvslistitem.layoutManager = manager
            binding.rcvslistitem.adapter = productlist
        }
    }
}