package com.xys;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
 
public class TestActivity0 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        TextView text = (TextView)this.findViewById(R.id.textView1);
        text.setText(this.getIntent().getStringExtra("name"));
 
        Button close = (Button)this.findViewById(R.id.button0);
        close.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
 
				TestActivity0.this.finish();
			}
		});
    }
 
}