package pt.ubi.di.pdm.a43760_t0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button botaostart;
    private Button botaosettings;
    private Button botaoexit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaostart = (Button) findViewById(R.id.botaostart);
        botaostart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openMessageType();
            }
        });

        botaosettings = (Button) findViewById(R.id.botaooptions);
        botaosettings.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openSettings();
            }
        });

        botaoexit = (Button) findViewById(R.id.botaoexit);
        botaoexit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finishAffinity();
            }
        });
    }

    //----------------------------------------------------------------------------------------------
    //Public funtions

    public void openMessageType()
    {
        Intent intent = new Intent(this, MessageType.class);
        startActivity(intent);
    }

    public void openSettings()
    {
        Intent intent = new Intent(this, DropdownContentEditor.class);
        startActivity(intent);
    }

    public void sendMessage(View view) {
    }
}