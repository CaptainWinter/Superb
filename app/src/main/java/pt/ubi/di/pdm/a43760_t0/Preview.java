package pt.ubi.di.pdm.a43760_t0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.Scanner;

public class Preview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        ImageButton botaoback = (ImageButton) findViewById(R.id.botaoback);
        botaoback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("/data/data/pt.ubi.di.pdm.a43760_t0/files/preview.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String content = new String();

        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            content = content+line+"\n";
        }

        final TextView contentpreview = findViewById(R.id.textopreview);
        contentpreview.setText(content);
    }
}