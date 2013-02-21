package org.istanbulhs.istanbulhsapp;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	//Sayi bilmece oyununda tuttugumuz sayi
	//Tum metod erisebilmek icin MainActiviy objesinin bir degiskeni olarak ekliyoruz
	private int sayi;
	
	//Bu metod bu activity ilk acildinda cagirilir
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //asagidaki satirda res\layout\activity_main.xml dosyasini okunup icinde tanimli objeler 
        //bu activity'ye ekle
        setContentView(R.layout.activity_main);
        
        //activity_main.xml dosyasinda tanimladigimiz textView1 id'li TextView'u al
        View myView = findViewById(R.id.textView1);
        
        //TextView, View tipinde bir obje. findViewById bize TextView'umuzu View tipinde verdi
        //TextView metodlarina ihtiyacimiz oldugu icin gelen View'u TextView'e ceviriyoruz ('casting' dedikleri)
        //Gelen View'un aslinda bir TextView oldugunu biliyoruz - Icinden TextView cikmazsa uygulama burda catlar
        TextView myTextView = (TextView)myView; 
        //Aldigimiz textview'un icindeki metni degistiriyoruz
        myTextView.setText("Bu yeni metin");
        
        //Rastgele bir sayi olusturuyoruz
        Random random = new Random();
        sayi = random.nextInt(20) + 1;
    }
    
    //Buton tiklandiginda cagirilan metod - xml'de Buton'un android:onClick ozelliginde yazdik
    //Argumani olan sender kliklemenin oldugu obje yani bu durumda Buton oluyor
    public void karsilastir(View sender) {
    	//Input kutucugunu aldik
    	EditText sayiGirisi = (EditText)findViewById(R.id.editText1);
    	//Icindeki rakami string olarak okuduk
    	String stringTahmin = sayiGirisi.getText().toString();
    	//Kutucugu sifirladik
    	sayiGirisi.setText("");
    	
    	//Sayiya cevirdik - dikkat hic kontrol yok - bosken butona basarsak uygulamamiz catlayacak
    	int tahmin = Integer.parseInt(stringTahmin);
    	
    	//Metin yazdigimiz TextView'lardan birini aldik
    	//Sayinin degerine gore farkli metin yazdiracagiz
    	View myView = findViewById(R.id.textView1);
        TextView myTextView = (TextView)myView; 
        
        //esitse bildiniz yazacagiz
    	if (tahmin == sayi){
    		myTextView.setText("Bildiniz!!");
        //Kucukse Yukari yazacagiz
    	} else if (tahmin < sayi) {
    		myTextView.setText("Yukari!");
    	//Buyukse Asagi diyecegiz
    	} else {
    		myTextView.setText("Asagi!");
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
