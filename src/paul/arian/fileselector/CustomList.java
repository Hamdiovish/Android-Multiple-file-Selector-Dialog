package paul.arian.fileselector;

/**
 * Created by Paul on 3/7/14.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;

public class CustomList extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] web;
    String ParentFolder;
    public CustomList(Activity context, String[] web,String path) {
        super(context, R.layout.list_single, web);
        this.context = context;
        this.web = web;
        ParentFolder = path;
        ViewHolderItem viewHolder;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
   if (view == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			view = inflater.inflate(R.layout.list_single, null, true);
			viewHolder = new ViewHolderItem();

			viewHolder.txtTitle = (TextView) view.findViewById(R.id.txt);
			viewHolder.imageView = (ImageView) view.findViewById(R.id.img);

			view.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolderItem) view.getTag();

		}
		viewHolder.txtTitle.setText(web[position]);
		Picasso.with(context).load(new File(ParentFolder + "/" + web[position])).placeholder(R.drawable.document)
				.resize(50, 50).into(viewHolder.imageView);
		return view;
	}

	static class ViewHolderItem {
		TextView txtTitle;
		ImageView imageView;
    }
}
