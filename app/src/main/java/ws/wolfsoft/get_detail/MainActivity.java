package ws.wolfsoft.get_detail;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener {
    SliderLayout mDemoSlider;



    LinearLayout linear1,showless,review;
    LinearLayout linear2;

    Typeface fonts1,fonts2;
    private ExpandableHeightGridView gridview;
    private ExpandableHeightListView listview;
    private ArrayList<Bean>Bean;
    private JayBaseAdapter baseAdapter;
    private ArrayList<Beanclass> beanclassArrayList;
    private GridviewAdapter gridviewAdapter;



    private int[] IMAGE = {R.drawable.status1,
            R.drawable.status2,
            R.drawable.status3,
            R.drawable.status4,
            R.drawable.status5,
            R.drawable.status6,
            R.drawable.status7,
            R.drawable.status8,
            R.drawable.status9,
            R.drawable.selesai};

    private String[] TITLE = {"Registrasi",
            "Pembayaran diterima",
            "Pemberkasan order",
            "Verifikasi order",
            "Proses pengujian / Kalibrasi",
            "Pengujian / Kalibrasi selesai",
            "Penyusunan laporan",
            "Verifikasi laporan",
            "Penerbitan laporan",
            "Order selesai"};

    private String[] RATING = {"Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan",
            "Sudah dilakukan"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        ********LISTVIEW***********
        listview = (ExpandableHeightListView)findViewById(R.id.listview);


        Bean = new ArrayList<Bean>();

        for (int i= 0; i< TITLE.length; i++){

            Bean bean = new Bean(IMAGE[i], TITLE[i],RATING[i]);
            Bean.add(bean);

        }

        baseAdapter = new JayBaseAdapter(MainActivity.this, Bean) {
        };

        listview.setAdapter(baseAdapter);


//        ********GRIDVIEW***********
        gridview = (ExpandableHeightGridView)findViewById(R.id.gridview);
        beanclassArrayList= new ArrayList<Beanclass>();

        gridviewAdapter = new GridviewAdapter(MainActivity.this, beanclassArrayList);
        gridview.setExpanded(true);

        gridview.setAdapter(gridviewAdapter);



//                ***********viewmore**********

        linear1 = (LinearLayout)findViewById(R.id.linear1);
        showless = (LinearLayout)findViewById(R.id.showless);

        linear2 = (LinearLayout)findViewById(R.id.linear2);

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.VISIBLE);
                linear1.setVisibility(View.GONE);

            }
        });

        showless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                linear2.setVisibility(View.GONE);
                linear1.setVisibility(View.VISIBLE);


            }
        });


    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }
}
