package com.seabutf.android.share.googleioextendedfragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCaller
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.seabutf.android.share.googleioextendedfragment.databinding.FragmentTabListBinding
import kotlinx.coroutines.launch

class TabListFragment : Fragment() {

    companion object {

        @JvmStatic
        fun newInstance() = TabListFragment()
    }

    private val viewModel: TabListViewModel by viewModels()
    private var binding: FragmentTabListBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //strictMode()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("UnsafeRepeatOnLifecycleDetector")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userVisibleHint = true
        initView()
        val ff  = MutableLiveData<String>()
        ff.value = "ff"
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun initView() {
        if(binding == null){
            return
        }

        binding!!.tlBanner.run {
            if (childCount <= 0) {
                addTab(newTab())
                addTab(newTab())
                addTab(newTab())
            }
        }

        val pagerAdapter = TabListPageAdapter(childFragmentManager, lifecycle)
        binding!!.vpBanner.adapter = pagerAdapter

        TabLayoutMediator(binding!!.tlBanner, binding!!.vpBanner) { tab, position ->
            when (position) {
                0 -> tab.text = "Tab1"
                1 -> tab.text = "Tab2"
                2 -> tab.text = "Tab3"
                else -> tab.text = ""
            }
        }.attach()
    }
}

class TabListPageAdapter(childFragmentManager : FragmentManager,
                         lifecycle: Lifecycle): FragmentStateAdapter(childFragmentManager, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return if(position == 1) NameListFragment.newInstance() else TabItemFragment.newInstance(position)
    }
}