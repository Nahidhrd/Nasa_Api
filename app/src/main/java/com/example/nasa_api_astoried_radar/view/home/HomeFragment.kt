package com.example.nasa_api_astoried_radar.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.nasa_api_astoried_radar.R
import com.example.nasa_api_astoried_radar.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.imageOfTheDay.observe(viewLifecycleOwner) { imageOfTheDay ->
            imageOfTheDay?.let {
                context?.let { it1 ->
                    Glide.with(it1)
                        .load(it.url)
                        .into(binding.imageView)
                }
            }
        }

        fun bindImage(imageView: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(this)
                    .load(it)
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .into(imageView)
            } ?: run {
                imageView.setImageResource(R.drawable.error)
            }
        }

    }

    }



