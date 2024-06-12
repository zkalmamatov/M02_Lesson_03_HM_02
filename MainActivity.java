package kg.less;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Player player = new Player(i, "Игрок " + i, new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                player.getPoints().add((int) (Math.random() * 100));
            }
            players.add(player);
        }

        System.out.println("Информация об игроке: ");
        players.forEach(System.out::println);

        players.sort(Comparator.comparing(Player::getName).reversed());

        System.out.println("\nИнформация об игроке после сортировки: ");
        players.forEach(System.out::println);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

}