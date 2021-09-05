package zolve.credit.card.us.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<B : ViewDataBinding> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder<B>>() {

    lateinit var mContext: Context

    abstract fun setLayoutItem(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
        mContext = parent.context
        val mView = LayoutInflater.from(parent.context).inflate(setLayoutItem(), parent, false)
        return ViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        onViewReady(holder, position)
    }

    override fun getItemCount() = setCount()

    class ViewHolder<T : ViewDataBinding>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mBinding = DataBindingUtil.bind<T>(itemView)!!
    }

    abstract fun setCount(): Int

    abstract fun onViewReady(holder: ViewHolder<B>, position: Int)

}