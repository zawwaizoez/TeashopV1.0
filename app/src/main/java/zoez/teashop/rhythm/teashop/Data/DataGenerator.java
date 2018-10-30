package zoez.teashop.rhythm.teashop.Data;

import android.content.Context;
import android.content.res.TypedArray;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import zoez.teashop.rhythm.teashop.Model.CardViewImg;
import zoez.teashop.rhythm.teashop.Model.Image;
import zoez.teashop.rhythm.teashop.Model.Inbox;
import zoez.teashop.rhythm.teashop.Model.MusicAlbum;
import zoez.teashop.rhythm.teashop.Model.MusicSong;
import zoez.teashop.rhythm.teashop.Model.People;
import zoez.teashop.rhythm.teashop.Model.ShopCategory;
import zoez.teashop.rhythm.teashop.Model.ShopProduct;
import zoez.teashop.rhythm.teashop.Model.Social;
import zoez.teashop.rhythm.teashop.R;
import zoez.teashop.rhythm.teashop.Utils.MaterialColor;
import zoez.teashop.rhythm.teashop.Utils.Tools;

@SuppressWarnings("ResourceType")
public class DataGenerator {

    private static Random r = new Random();

    public static int randInt(int max) {
        int min = 0;
        return r.nextInt((max - min) + 1) + min;
    }





    /**
     * Generate dummy data CardViewImg
     *
     * @param ctx   android context
     * @param count total result data
     * @return list of object
     */


    /**
     * Generate dummy data people
     *
     * @param ctx android context
     * @return list of object
     */


    /**
     * Generate dummy data social
     *
     * @param ctx android context
     * @return list of object
     */


    /**
     * Generate dummy data inbox
     *
     * @param ctx android context
     * @return list of object
     */

    /**
     * Generate dummy data image
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<Image> getImageDate(Context ctx) {
        List<Image> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.sample_images);
        String name_arr[] = ctx.getResources().getStringArray(R.array.sample_images_name);
        String date_arr[] = ctx.getResources().getStringArray(R.array.general_date);
        for (int i = 0; i < drw_arr.length(); i++) {
            Image obj = new Image();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.name = name_arr[i];
            obj.brief = date_arr[randInt(date_arr.length - 1)];
            obj.counter = r.nextBoolean() ? randInt(500) : null;
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }

    /**
     * Generate dummy data shopping category
     *
     * @param ctx android context
     * @return list of object
     */


    /**
     * Generate dummy data shopping product
     *
     * @param ctx android context
     * @return list of object
     */



    /**
     * Generate dummy data music song
     *
     * @param ctx android context
     * @return list of object
     */


    /**
     * Generate dummy data music album
     *

     * @return list of object
     */

}
