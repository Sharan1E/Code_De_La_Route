package com.example.code_de_la_route;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private final List<Listview_element> listData;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public CustomListAdapter(Context aContext,  List<Listview_element> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_layout, null);
            holder = new ViewHolder();
            holder.ThemeLogoView = convertView.findViewById(R.id.imageView_theme_logo);
            holder.ThemeNameView = convertView.findViewById(R.id.textView_theme_description);
            holder.ThemeNumberView = convertView.findViewById(R.id.textView_theme_number);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Listview_element element = this.listData.get(position);
        holder.ThemeNameView.setText(element.getThemeName());
        holder.ThemeNumberView.setText(element.getThemeNumber());

        int imageId = this.getDrawableResIdByName(element.getThemelogoName());

        holder.ThemeLogoView.setImageResource(imageId);

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView ThemeLogoView;
        TextView ThemeNameView;
        TextView ThemeNumberView;
    }

}