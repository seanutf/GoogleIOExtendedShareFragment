package com.seabutf.android.share.googleioextendedfragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.strictmode.FragmentStrictMode
import androidx.fragment.app.strictmode.SetRetainInstanceUsageViolation
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.seabutf.android.share.googleioextendedfragment.databinding.FragmentNameListBinding
import com.seabutf.android.share.googleioextendedfragment.databinding.ItemNameListBinding
import kotlinx.coroutines.launch

class NameListFragment : Fragment() {

    private var binding: FragmentNameListBinding? = null
    private val listAdapter = NameListAdapter()
    private val viewModel: NameListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        strictMode()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNameListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        if(binding == null){
            return
        }

        binding?.rvList?.adapter = listAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = NameListFragment()
    }
}

class NameListAdapter: RecyclerView.Adapter<NameListViewHolder>(){
    private var nameList: List<NameListUi> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameListViewHolder {
        return NameListViewHolder.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: NameListViewHolder, position: Int) {
        val itemNameUi = nameList[position]
        holder.bindData(itemNameUi)
    }

    override fun getItemCount() = nameList.size
}
class NameListViewHolder(private val itemBinding: ItemNameListBinding): RecyclerView.ViewHolder(itemBinding.root) {

    companion object {

        @JvmStatic
        fun createViewHolder(parent: ViewGroup): NameListViewHolder{
            val inflater = LayoutInflater.from(parent.context)
            return NameListViewHolder(ItemNameListBinding.inflate(inflater, parent, false))
        }
    }

    fun bindData(uiData: NameListUi){
        itemBinding.tvName.text = uiData.name
        val color = if(uiData.selected) {
            Color.parseColor("#ff994f")
        } else {
            Color.parseColor("#ffffff")
        }

        itemBinding.llItemBg.setBackgroundColor(color)
    }
}