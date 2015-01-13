package yalantis.com.sidemenu.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import yalantis.com.sidemenu.R;

/**
 * Created by Konstantin on 19.12.2014.
 */
public class MenuAdapter extends SimpleBaseAdapter<String> {

    public MenuAdapter(Context context, List<String> list) {
        super(context, list);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater vi = LayoutInflater.from(context);
            convertView = vi.inflate(R.layout.menu_list_item, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String item = getItem(position);

        return convertView;
    }


    class ViewHolder {
        TextView txtRole;
    }
}
