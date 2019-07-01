package r99.developer.id.kowlegesharing2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import r99.developer.id.kowlegesharing2.Model.MLaporan;
import r99.developer.id.kowlegesharing2.R;

public class AdapterLaporan extends ArrayAdapter<MLaporan> {


    List<MLaporan> ListLaporan;
    Context context;
    int layout;

    public AdapterLaporan(Context context, int layout,List<MLaporan> ListLaporan){
        super(context,layout,ListLaporan);
        this.context = context;
        this.layout = layout;
        this.ListLaporan = ListLaporan;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        View v= convertView;
        LaporanHolder holder;

        if (v==null){
            LayoutInflater vi =((Activity)context).getLayoutInflater();
            v=vi.inflate(layout,parent,false);

            holder = new LaporanHolder();
            holder.Nama = (TextView) v.findViewById(R.id.nama_laporan);
            holder.Judul =(TextView) v.findViewById(R.id.judul_laporan);
            holder.Tanggal = (TextView) v.findViewById(R.id.tanggal_laporan);
            holder.Dokumen = (ImageView) v.findViewById(R.id.gambar_laporan);

            v.setTag(holder);
        }else {
            holder=(LaporanHolder) v.getTag();
        }

        MLaporan mlaporan = ListLaporan.get(position);
        holder.Nama.setText(mlaporan.getName());
        holder.Judul.setText(mlaporan.getJudul());
        holder.Tanggal.setText(mlaporan.getTanggal());
        holder.Dokumen.setImageResource(mlaporan.getImage());


        return v;

    }

    static class LaporanHolder{
        TextView Nama,Judul,Tanggal;
        ImageView Dokumen;
    }

}
