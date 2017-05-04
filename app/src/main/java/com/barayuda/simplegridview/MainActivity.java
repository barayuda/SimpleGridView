package com.barayuda.simplegridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private String[] images = new String[]{
            "http://assets.pokemon.com/assets//cms2-nb-no/img/trading-card-game/_tiles/sun-moon/sm01_launch_169-en.jpg",
            "http://assets.pokemon.com/assets//cms2-nb-no/img/watch-pokemon-tv/_tiles/season19-ptv-169-no.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/_tiles/pokemon-go/12122016_2/pokemon-go-169.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/_tiles/pokemon-sun-moon/mewtwo-mega-stones/mega-mewtwo-distribution-169-en.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/_tiles/pokemon-go/04132017/pokemon-go-169.jpg",
            "http://assets.pokemon.com/assets//cms2/img/attend-events/championship/2016-nationals/nationals-mobile_720x408.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/_tiles/super-mystery-dungeon/pokemon-super-mystery-dungeon-e3-169.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/_tiles/pokemon-sun-moon/09142016/pokemon-sun-moon-169-en.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/_tiles/pokemon-go/02082017/pokemon-go-169.jpg",
            "http://assets.pokemon.com/assets/cms2/img/video-games/video-games/pokemon_rumble_u/pokemon_rumble_u_main_169.jpg"
    };

    private GridView gvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Pokemon");
        gvItem = (GridView)findViewById(R.id.gv_item);
        ItemGridAdapter itemGridAdapter = new ItemGridAdapter(MainActivity.this, images);
        gvItem.setAdapter(itemGridAdapter);
        gvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailImageActivity.toDetailImageActivity(MainActivity.this, images[position]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_staggered) {
            StaggeredGridActivity.toStaggeredGridActivity(MainActivity.this);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
