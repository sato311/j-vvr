package co.jp.sato.yama.vvib2;

//import android.os.Bundle;
//import co.jp.kos.vvib.R;
import android.app.Activity;
//import android.view.Menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import 	android.os.Vibrator;
//import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends Activity implements OnClickListener{
	public Vibrator myVibrator;
//	public EditText editText1;
//	private static final String TAG="SSKKm";
	public int statusv;
	public long f_target;
	public long period;
	public long pattern[];
	
	public void setVib() {
		statusv = 1;
		myVibrator.vibrate(pattern,1/*repeat_index*/);		
	}
	public void clrVib() {
		statusv = 0;
		myVibrator.cancel();
	}
	public long getPeriod(String str) {
		long n;
		n = Integer.decode(str);
//		Log.i("SSKK","n="+n);
		return n;
	}
	public void onClick(View v) {
	if ((v.getId()==R.id.button1) && (statusv == 0)) {
//		if (statusv == 1)
//			return;
//		long pattern[];
//		int repeat_index = 1; // from repeat index, -1 is no repeat
		
		EditText editText1=(EditText)findViewById(R.id.editText1);
		String str = editText1.getText().toString();
		if (str.length()>0) {
			f_target = getPeriod(str);

			if ((f_target>400) || (f_target<1)) f_target = 50;
			period = 1000/f_target;

			pattern[1] = period;
			pattern[2] = period;
		}
//		if (f_target>400)
//			f_target = 50;
//		Log.i("SSKK","f_target="+f_target);		
		
//		long period;
//		if (f_target > 0)
//			period = 1000/f_target;
//		else
//			period = 1000;
		
//		pattern = new long [3];
//		pattern[0] = 10; //wait ms
//		pattern[1] = period;
//		pattern[2] = period;

		TextView myText1=(TextView)findViewById(R.id.textView1);
		myText1.setText((int)f_target + "Hz," + ","+period+"ms");		
		
//		statusv = 1;
//		myVibrator.vibrate(pattern,1/*repeat_index*/);
		setVib();
	}
	else if (v.getId()==R.id.button2) {
//		statusv = 0;
//		myVibrator.cancel();
		clrVib();
	}
}
	@Override	 
	protected void onPause() {
		super.onPause();
//		statusv = 0;
//		myVibrator.cancel();
		clrVib();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myVibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);		
		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(this);
		Button button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(this);
		
		f_target = 50;
		period = 1000/f_target;
		pattern = new long [3];
		pattern[0] = 10; //wait ms
		pattern[1] = period;
		pattern[2] = period;

//		TextView myText1=(TextView)findViewById(R.id.mytxt);
//		myText1.setText("f(Hz) "+(int)f_target);		

//		editText1=(EditText)findViewById(R.id.editText1);
//		statusv = 0;
		statusv = 0;
	}
}
