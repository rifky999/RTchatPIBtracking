package r99.developer.id.kowlegesharing2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import r99.developer.id.kowlegesharing2.Adapter.AdapterLaporan;
import r99.developer.id.kowlegesharing2.Lihat.LihatLaporan;
import r99.developer.id.kowlegesharing2.Model.MLaporan;
import r99.developer.id.kowlegesharing2.R;
import r99.developer.id.kowlegesharing2.Upload.UploadLaporan;

public class fr_laporan extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fr_laporan,container,false);
        ListView listView = (ListView) root.findViewById(R.id.list_laporan);
        final List<MLaporan> listLaporan = new ArrayList<MLaporan>();

        Button btn = (Button) root.findViewById(R.id.tambah_laporan);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), UploadLaporan.class);
                startActivity(i);
            }
        });

         MLaporan laporan1,laporan2,laporan3;
         laporan1 = new MLaporan("rifky","JUDUL","12-10-10",R.drawable.ic_menu_camera);
         laporan2 = new MLaporan("rifky","JUDUL","12-10-10",R.drawable.ic_menu_camera);
         laporan3 = new MLaporan("rifky","JUDUL","12-10-10",R.drawable.ic_menu_camera);
            listLaporan.add(laporan1);
            listLaporan.add(laporan2);
            listLaporan.add(laporan3);

            listView.setAdapter(new AdapterLaporan(getContext(),R.layout.list_laporan,listLaporan));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   MLaporan laporan = listLaporan.get(position);
                    Log.d("adapter clicked", "onItemClick: "+laporan.getJudul());
//                    getActivity().finish();
                    Intent i = new Intent(getContext(), LihatLaporan.class);
                    startActivity(i);
                }
            });
        return root;
    }
}