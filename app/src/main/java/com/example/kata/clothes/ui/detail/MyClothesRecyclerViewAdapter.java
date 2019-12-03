package com.example.kata.clothes.ui.detail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.kata.clothes.R;

import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.ui.detail.ClothesFragment.OnListFragmentInteractionListener;


import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ClothesModel} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyClothesRecyclerViewAdapter extends RecyclerView.Adapter<MyClothesRecyclerViewAdapter.ViewHolder> {
    private int height;
    private final List<ClothesModel> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyClothesRecyclerViewAdapter(List<ClothesModel> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_clothes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).getId().toString());
        //holder.mContentView.setText(mValues.get(position).getName());
        String uriString = mValues.get(position).getUri();
        if(uriString != null && !uriString.isEmpty()){
            holder.mImageView.setImageURI(Uri.parse(uriString));
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

        holder.mView.setOnLongClickListener(new View.OnLongClickListener(){
            @SuppressLint("RestrictedApi")
            @Override
            public boolean onLongClick(View view) {
                if (null != mListener) {
                    MenuBuilder menuBuilder =new MenuBuilder(view.getContext());
                    MenuInflater inflater = new MenuInflater(view.getContext());
                    inflater.inflate(R.menu.clothes_menu, menuBuilder);
                    MenuPopupHelper optionsMenu = new MenuPopupHelper(view.getContext(), menuBuilder, view);
                    optionsMenu.setForceShowIcon(true);

                    menuBuilder.setCallback(new MenuBuilder.Callback() {
                        @Override
                        public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.edit_clothes:
                                    mListener.onListFragmentInteraction(holder.mItem, "edit");
                                    return true;
                                case R.id.delete_clothes: // Handle option2 Click
                                    mListener.onListFragmentInteraction(holder.mItem, "delete");
                                default:
                                    return false;
                            }
                        }

                        @Override
                        public void onMenuModeChange(MenuBuilder menu) {}
                    });
                    optionsMenu.show();
                }

                return true;
            }
        }
        );
    }

    // method to open a popup menu(list) upon long click in the recyclerView item

    private void showMenu(View view){

//        PopupMenu popup = new PopupMenu(view.getContext(),view);
//
//        popup.getMenuInflater()
//                .inflate(R.menu.clothes_menu, popup.getMenu());
//
//
//        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                return false;
//            }
//        });
//
//        popup.show();

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final TextView mIdView;
        //public final TextView mContentView;
        public final ImageView mImageView;
        public ClothesModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            //mIdView = view.findViewById(R.id.cloth_item_number);
            //mContentView = view.findViewById(R.id.cloth_content);
            mImageView = view.findViewById((R.id.cloth_content_iv));
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
    }
}
