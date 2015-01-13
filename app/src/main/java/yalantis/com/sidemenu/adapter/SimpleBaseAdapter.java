package yalantis.com.sidemenu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Konstantin on 19.12.2014.
 */
public abstract class SimpleBaseAdapter<T> extends BaseAdapter {

    protected final Context context;
    protected final LayoutInflater inflater;
    protected List<T> items;

    public SimpleBaseAdapter(Context context, List<T> items) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public T getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }
}