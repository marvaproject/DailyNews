package com.daffa.dailynews.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.FragmentHomeBinding
import com.daffa.dailynews.network.response.HomeResponseItem

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding as FragmentHomeBinding

    private var _viewmodel : HomeViewModel? = null
    private val viewModel get() = _viewmodel as HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _viewmodel = ViewModelProvider(this)[HomeViewModel::class.java]

        viewModel.getHomeModel()
        viewModel.getListHome().observe(viewLifecycleOwner){
            showData(it)
        }
    }

    private fun showData(data: List<HomeResponseItem>?) {
        binding.rvhome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = data?.let { HomeAdapter(it) }
        }

    }
}