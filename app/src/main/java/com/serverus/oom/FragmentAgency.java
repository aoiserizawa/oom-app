package com.serverus.oom;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAgency extends Fragment {
    private ImageView bannerBackground;
    private ImageView firstConvertionImg;
    private ImageView secondConvertionImg;
    private ImageView thirdConvertionImg;

    public FragmentAgency() {
        // Required empty public constructor
    }


    //    public static int calculateInSampleSize(
//            BitmapFactory.Options options, int reqWidth, int reqHeight) {
//        // Raw height and width of image
//        final int height = options.outHeight;
//        final int width = options.outWidth;
//        int inSampleSize = 1;
//
//        if (height > reqHeight || width > reqWidth) {
//
//            final int halfHeight = height / 2;
//            final int halfWidth = width / 2;
//
//            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
//            // height and width larger than the requested height and width.
//            while ((halfHeight / inSampleSize) > reqHeight
//                    && (halfWidth / inSampleSize) > reqWidth) {
//                inSampleSize *= 2;
//            }
//        }
//
//        return inSampleSize;
//    }
//
//    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
//                                                         int reqWidth, int reqHeight) {
//
//        // First decode with inJustDecodeBounds=true to check dimensions
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(res, resId, options);
//
//        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//        // Decode bitmap with inSampleSize set
//        options.inJustDecodeBounds = false;
//        return BitmapFactory.decodeResource(res, resId, options);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agency, container, false);

        // this solve the problem when the orientation changed it goes back to "OOm"
        getActivity().setTitle("Agency");

//        bannerBackground = (ImageView) view.findViewById(R.id.background_banner);
//        firstConvertionImg = (ImageView) view.findViewById(R.id.first_converstion_image);
//        secondConvertionImg = (ImageView) view.findViewById(R.id.second_converstion_image);
//        thirdConvertionImg = (ImageView) view.findViewById(R.id.third_conversion_image);
//
//        bannerBackground.setImageBitmap(
//                decodeSampledBitmapFromResource(getResources(), R.drawable.agency_background_banner, 100, 100));
//
//        firstConvertionImg.setImageBitmap(
//                decodeSampledBitmapFromResource(getResources(), R.drawable.first_conversion, 200, 100));
//
//        secondConvertionImg.setImageBitmap(
//                decodeSampledBitmapFromResource(getResources(), R.drawable.second_conversion, 200, 100));
//
//        thirdConvertionImg.setImageBitmap(
//                decodeSampledBitmapFromResource(getResources(), R.drawable.third_conversion, 200, 100));

        return view;
    }


//    }

}
