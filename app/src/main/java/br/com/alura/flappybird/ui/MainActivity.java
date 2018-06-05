package br.com.alura.flappybird.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import br.com.alura.flappy_bird.R;
import br.com.alura.flappybird.engine.Game;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_frame)
    public FrameLayout container;

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.game = new Game(this);
        container.addView(game);

    }

    @Override
    protected void onResume() {
        super.onResume();
        game.inicia();
        new Thread(game).start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        game.pausa();
    }
}
