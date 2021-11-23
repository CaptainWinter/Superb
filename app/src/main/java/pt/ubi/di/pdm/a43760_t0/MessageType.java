package pt.ubi.di.pdm.a43760_t0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MessageType extends AppCompatActivity
{
    private ImageButton botaoback;
    private Button botaomessage;
    private Button botaomail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_type);

        botaoback = (ImageButton) findViewById(R.id.botaoback);
        botaoback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        botaomessage = (Button) findViewById(R.id.botaostart);
        botaomessage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                writeMessage();
            }
        });

        botaomail = (Button) findViewById(R.id.botaomail);
        botaomail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                writeMail();
            }
        });
    }

    public void writeMessage()
    {
        Intent intent = new Intent(this, WriteMessage.class);
        startActivity(intent);
    }

    public void writeMail()
    {
        Intent intent = new Intent(this, WriteMail.class);
        startActivity(intent);
    }
}