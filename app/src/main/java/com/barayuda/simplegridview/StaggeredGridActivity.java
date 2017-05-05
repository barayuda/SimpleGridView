package com.barayuda.simplegridview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.etsy.android.grid.StaggeredGridView;

public class StaggeredGridActivity extends AppCompatActivity {

    private StaggeredGridView staggeredGridView;
    private String[] items = new String[]{
            "https://s-media-cache-ak0.pinimg.com/474x/59/bf/3f/59bf3fa0c94e185ddddf2a0d53a1f1dd.jpg",
            "https://s-media-cache-ak0.pinimg.com/564x/17/a7/67/17a7674032d40de6cc218af3f14061d3.jpg",
            "https://s-media-cache-ak0.pinimg.com/474x/39/aa/9d/39aa9db90d3e4b06c1eff382d93ebb57.jpg",
            "https://s-media-cache-ak0.pinimg.com/474x/a3/ab/73/a3ab7374c2eb919cfffac23eace01033.jpg",
            "https://s-media-cache-ak0.pinimg.com/564x/77/bc/72/77bc72c07f04f2cfad9f8b6aa8209159.jpg",
            "https://s-media-cache-ak0.pinimg.com/736x/7f/2e/79/7f2e790b6ebb34699b887181d7a6a3ed.jpg",
            "https://s-media-cache-ak0.pinimg.com/564x/86/80/be/8680be8b94efb4ea78f8e58a0b1bc803.jpg",
            "https://s-media-cache-ak0.pinimg.com/564x/37/43/37/37433769be71de494020524cfa643659.jpg",
            "https://s-media-cache-ak0.pinimg.com/564x/e4/84/ee/e484ee54682924e1a70dfb90b8e3d952.jpg",
            "https://s-media-cache-ak0.pinimg.com/564x/1e/09/41/1e0941bb6d1c09108347d04ffe8924cc.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);

        getSupportActionBar().setTitle("Power Rangers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        staggeredGridView = (StaggeredGridView)findViewById(R.id.gv_staggered);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(StaggeredGridActivity.this, items);
        staggeredGridView.setAdapter(itemGridAdapter);
        staggeredGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(StaggeredGridActivity.this, items[position]);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void toStaggeredGridActivity(Context context){
        context.startActivity(new Intent(context, StaggeredGridActivity.class));
    }
}
