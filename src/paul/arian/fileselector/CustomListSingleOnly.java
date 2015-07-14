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

public class CustomListSingleOnly extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] web;
    String ParentFolder;
    ParentFolder = path;
    public CustomListSingleOnly(Activity context, String[] web ,String path) {
        super(context, R.layout.list_single_only, web);
        this.context = context;
        this.web = web;
            ParentFolder = path;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
       if (view == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			view = inflater.inflate(R.layout.list_single_only, null, true);

			viewHolder = new ViewHolderItem();
			viewHolder.txtTitle = (TextView) view.findViewById(R.id.txt);
			viewHolder.imageView = (ImageView) view.findViewById(R.id.img);

			view.setTag(viewHolder);

		} else {
			viewHolder = (ViewHolderItem) view.getTag();

		}

		viewHolder.txtTitle.setText(web[position]);
		if ((new File(ParentFolder + "/" + web[position])).isDirectory()) {
			viewHolder.imageView.setImageResource(R.drawable.folder);// sets to
																		// folder
		} else if ((new File(ParentFolder + "/" + web[position])).isFile()) {// sets
																				// to
																				// file
			Picasso.with(context).load(new File(ParentFolder + "/" + web[position]))
					.placeholder(R.drawable.document_gray).resize(50, 50).into(viewHolder.imageView);
		}
		return view;
	}

	static class ViewHolderItem {

		TextView txtTitle;
		ImageView imageView;

	}
}

