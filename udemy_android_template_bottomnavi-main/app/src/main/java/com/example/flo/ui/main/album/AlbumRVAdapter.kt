package com.example.flo.ui.main.album

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flo.data.entities.Album
import com.example.flo.databinding.ItemAlbumBinding

class AlbumRVAdapter(private val albumList : ArrayList<Album>) : RecyclerView.Adapter<AlbumRVAdapter.ViewHolder>(){

    interface MyItemClickListener{
        fun onItemClick(album : Album)
        fun onRemoveAlbum(position: Int)
    }

    private lateinit var myItemClickListener: MyItemClickListener
    fun setMyItemClickListener(itemClickListener: MyItemClickListener){
        myItemClickListener = itemClickListener
    }

    fun addItem(album: Album){
        albumList.add(album)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        albumList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemAlbumBinding = ItemAlbumBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    //스크롤 할 때마다 불러짐
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumList[position])
        holder.itemView.setOnClickListener{
           myItemClickListener.onItemClick(albumList[position])
        }
        //holder.binding.itemAlbumTitleTv.setOnClickListener{myItemClickListener.onRemoveAlbum(position)}

    }

    override fun getItemCount(): Int =albumList.size

    inner class ViewHolder(val binding : ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(album: Album){
            binding.itemAlbumTitleTv.text = album.title
            binding.itemAlbumSingerTv.text = album.singer
            binding.itemAlbumCoverImgIv.setImageResource(album.coverImg!!)

        }
    }





}