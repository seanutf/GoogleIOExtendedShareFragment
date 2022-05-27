package com.seabutf.android.share.googleioextendedfragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.seabutf.android.share.googleioextendedfragment.databinding.FragmentTabItemBinding
import kotlinx.coroutines.launch

private const val ARG_PARAM1 = "param1"

class TabItemFragment : Fragment() {

    private var itemPosition: Int = 0
    private var binding: FragmentTabItemBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemPosition = it.getInt(ARG_PARAM1, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabItemBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        if(binding == null){
            return
        }

        binding?.tvPosition?.text = "第$itemPosition 页"

        when(itemPosition) {
            0 -> {
                setBgColor("#1ff011")
            }

            1 -> {
                setBgColor("#93bbff")
            }

            2 -> {
                setBgColor("#9f9fff")
            }

            3 -> {
                setBgColor("#e9f94f")
            }
        }
    }

    private fun setBgColor(colorStr: String) {
        requireParentFragment()
        binding?.flBg?.setBackgroundColor(Color.parseColor(colorStr))
    }

    companion object {

        @JvmStatic
        fun newInstance(position: Int) =
            TabItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, position)
                }
            }
    }
}