package com.example.kata.clothes.ui.create;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kata.clothes.ClothesApplication;
import com.example.kata.clothes.R;
import com.example.kata.clothes.model.ClothesModel;
import com.example.kata.clothes.ui.main.MainActivity;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import static android.support.v4.provider.FontsContractCompat.FontRequestCallback.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFragment extends Fragment implements CreateScreen {
    private static final String TAG = "createFragment";
    private Button takePictureButton;
    private ImageView imageView;
    private Uri file = null;
    private ClothesModel newCloth;
    private TextInputEditText categoryEditText;
    private TextInputEditText favouriteEditText;
    private Button createClothButton;

    private ClothesModel selectedCloth = null;

    @Inject
    CreatePresenter createPresenter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateFragment newInstance(String param1, String param2) {
        CreateFragment fragment = new CreateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClothesApplication.injector.inject(this);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        this.selectedCloth = ((MainActivity)getActivity()).getSelectedCloth();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                takePictureButton.setEnabled(true);
                createClothButton.setEnabled(true);
            }
        }
    }

    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            //if (resultCode == RESULT_OK) {
                Log.e(TAG, "-------------------------------------------------------------ActivityResult:" + this.file.toString());
                imageView.setImageURI(this.file);
            //}
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create, container, false);
        //Get the categories list
        createPresenter.attachScreen(this);

        takePictureButton = (Button) v.findViewById(R.id.button_image);
        imageView = (ImageView) v.findViewById(R.id.imageview);
        categoryEditText = (TextInputEditText) v.findViewById(R.id.cat_input);
        favouriteEditText = (TextInputEditText) v.findViewById(R.id.fav_input);
        createClothButton = (Button) v.findViewById((R.id.button_create));


        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            takePictureButton.setEnabled(false);
            createClothButton.setEnabled(false);
            ActivityCompat.requestPermissions(getActivity(), new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }

        if(this.selectedCloth != null){
            this.file = Uri.parse(this.selectedCloth.getUri());
            imageView.setImageURI(this.file);
            categoryEditText.setText(this.selectedCloth.getCategory().getName());
            favouriteEditText.setText(this.selectedCloth.getLabel().getName());
        }

        takePictureButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());

                //OnCLick Stuff
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = Uri.fromFile(getOutputMediaFile());
                intent.putExtra(MediaStore.EXTRA_OUTPUT, file);
                Log.e(TAG, "-------------------------------------------------------------Camera pic path:" + file.toString());
                startActivityForResult(intent, 100);
            }
        });

        createClothButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String cat = categoryEditText.getText().toString();
                String fav = favouriteEditText.getText().toString();
                if(file != null && imageView.getDrawable() != null && cat!=null && !cat.isEmpty()){
                    saveNewCloth(cat, fav);
                    ShowMessageDialog("Item saved successfully!");
                    //reset the selected item
                    ((MainActivity)getActivity()).setSelectedCloth(null);
                    Log.e(TAG, "-------------------------------------------------------------save new item into DB-" + cat + "-" );
                    imageView.setImageResource(R.drawable.ic_camera_alt_black_24dp);
                    categoryEditText.setText(null);
                    favouriteEditText.setText(null);
                    file = null;
                }else{
                    ShowMessageDialog("Make sure you have a picture and a category!");
                }
        }
        });
        return v;
    }

    public void ShowMessageDialog(String str){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setCancelable(false);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void saveNewCloth(String cat, String fav){
        String uri = null;
        uri = file.toString();
        if(this.selectedCloth != null){
            createPresenter.updateCloth(cat, fav, uri, this.selectedCloth);
        }else{
            createPresenter.saveNewCloth(cat, fav, uri);
        }


        Log.e(TAG, "-------------------------------------------------------------save new item into DB: " + cat + "--" + fav);
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStop() {
        super.onStop();
        createPresenter.detachScreen();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }

}
