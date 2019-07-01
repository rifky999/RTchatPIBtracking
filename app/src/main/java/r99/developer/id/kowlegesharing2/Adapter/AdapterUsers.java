package r99.developer.id.kowlegesharing2.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import r99.developer.id.kowlegesharing2.Model.MUsers;
import r99.developer.id.kowlegesharing2.R;

public class AdapterUsers {

    private Context mcontext;
    private List<MUsers> ai = new ArrayList();

    public AdapterUsers(@NonNull Context context,ArrayList<MUsers> list){
        super();

        mcontext = context;
        ai = list;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitem = convertView;


        if (listitem==null) {
            listitem = LayoutInflater.from(mcontext).inflate(R.layout.list_users,parent,false);

            MUsers current = ai.get(position);

            TextView name = listitem.findViewById(R.id.name);
            name.setText(current.getName());
        }
        return listitem;
    }

}
