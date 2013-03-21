android-egitim
================

Anrdoid eğitimi sırasında yazdığımız uygulama

1. derste yazdığımız kodlara 1.ders tag'i altından ulaşabilirsiniz. 
	Basit bir sayı bilmece oyunu yazdık. Bir ekran yaptık. Ekranda yazı gösterdik. Ekrandan sayı girişi yaptık. Sayı altında veya üstünde olmasına göre ekrana yazı yazdık. 
	

2. derste yazdığımız kodlara aynı şekilde 2.ders tag'i ile ulaşabilirsiniz.
	Bir giriş ekranı yaptık. Sayı oyunumuza bu giriş ekranından buton koyduk. Böylelikle bir Activity'nin içinden yeni bir Activity yaratmayı öğrendik.
	Bir ListActivity yarattık. İsimlerden oluşan bir liste gösterdik. İsmin üstüne tıklandığında o isme ait email adresini gösteren bir kutucuk göstermeyi gördük. 
	
	

![Github'da Tag seçme](https://raw.github.com/istanbulhs/android-egitim/master/README-images/tag-screenshot.png)

Veya en kısası aşağıdaki linkten istediğiniz dersin kodunu indirebilirsiniz:
![Dersler](https://github.com/istanbulhs/android-egitim/tags)


5. ders öncesinde kendi bilgisayarınızda yapmanız gereken hazırlıklar var. 

Google Android Maps API v2 ile Android'de uygulama geliştirme için yapılması gerekenler
========================================================================================
1. SDK Manager’dan Extras’ın altında Play Store SDK’yi indirin. 
   * SDK Manager’i açmak için
   
     ![Eclipse'ten SDK Manager](https://raw.github.com/istanbulhs/android-egitim/master/README-images/sdk-manager-from-eclipse.png)
   * Google Play Store SDK’yi ve Android 2.2’nin altındaki SDK Platform’u seçin
     ![Google Play Services paketi](https://raw.github.com/istanbulhs/android-egitim/master/README-images/google-play-services-package.png)
     ![Android 2.2 paketi](https://raw.github.com/istanbulhs/android-egitim/master/README-images/android-2.2.png)
2. Google Play SDK’yi bir proje olarak Eclipse’e ekleyin. 
   Şöyle: Eclipse’te **File > Import**'ı tıklayın. 
   Burda **Android > Existing Android Code into Workspace** ‘i seçin. 
   Açılan pencerede __Root Directory__ kısmına Browse butonu ile google_play_services klasorunu koyun. Bu klasör <ADT-Bundle’i-koyduğunuz-yer>\sdk\extras\google\google_play_services ‘de bulunuyor

   Bu yeri ekleyince Projects kısmının altına eklenen birkaç proje göreceksiniz. google-play-services_lib adındakini seçin. Ve Finish diyerek projeyi alın.
	
   ![Proje olarak import edin](https://raw.github.com/istanbulhs/android-egitim/master/README-images/import-as-android-project.png)
	
3. Play Store projesini IstanbulHsApp projesine Android Library olarak ekleyin.
   Bunun için IstanbulHsApp projesinin üstünde sağ tıklayıp Properties’e tıklayın. Aşağıdaki gibi bir pencere açılacak. Açılan pencerenin sol kanadında Android’i seçin. Sağ kanadın altında Library denen yerin yanındaki Add butonunu tıklayın. Burda yeni eklediğimiz google-play-services_lib projesini seçin. Ekledikten sonraki görüntünün aşağıdakine benzer olması gerekiyor. 

   ![Library ekleme](https://raw.github.com/istanbulhs/android-egitim/master/README-images/add-library-as-dependency.png)

   Burda projenizi bir build edin. Herşey yolunda mı diye bir bakın. 

4. Google Maps API Key alın. 
   * androiddebugkey’inin SHA1 fingerprintini almamız gerekiyor
     **Linux ve Mac**
     <code>keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android</code>

     **Windows**
     <code>keytool -list -v -keystore "C:\Users\your_user_name\.android\debug.keystore" -alias androiddebugkey -storepass android -keypass android</code>

     Keytool bulunamadı gibi bir hata alırsanız o zaman Java’nın kurulu olduğu yere gidin burda bin klasörünün içinde olması gerekiyor
     Genelde Windows icin
     <code>C:\Program Files\Java\jdk1.6.0_25\bin\keytool.exe</code> gibi birşey olması gerekir

     Bu size suna benzer birsey donecek:
     <code>
     Alias name: androiddebugkey 
     Creation date: 09.Mar.2013 
     Entry type: PrivateKeyEntry
     Certificate chain length: 1
     Certificate[1]:
     Owner: CN=Android Debug, O=Android, C=US
     Issuer: CN=Android Debug, O=Android, C=US 
     Serial number: 513b3a25
     Valid from: Sat Mar 09 15:33:25 EET 2013 until: Mon Mar 02 15:33:25 EET 2043
     Certificate fingerprints:
     MD5:  66:CE:69:04:15:FD:9C:1A:FD:51:45:97:F2:89:EC:74
     SHA1: CF:DE:2C:3E:CA:F6:EC:3D:A0:30:70:CB:CA:D3:BD:9C:A0:95:11:3C
     Signature algorithm name: SHA1withRSA
     Version: 3
     </code>
     Burda bizi ilgilendiren kısım Certificate fingerprints'in altındaki SHA1'nın yanındaki kısım.
   * Google API’de bir proje yaratın. 
     https://code.google.com/apis/console/?pli=1
	 Sağ üstte tıklayıp Hackerspace-Egitim adında yeni bir proje yaratın.
	 Servislerin arasından Google Maps Android API v2 ‘yi açık konumuna getirin.
	 Gene sol üstte API Access’i tıklayın.
	 Burda Create New Android Key butonunu tıklayın. Açılan pencereye SHA1  Fingerprintimi ve package name’i araya bir ; koyarak ekleyin.
	 Kendi keyinizi kullanmaniz gerekiyor.
     <code>XX:DE:2C:3E:CA:F6:EC:3D:A0:30:DD:CB:CA:D3:FF:9C:A0:95:11:3C;org.istanbulhs.istanbulhsapp</code>
	 Android App için oluşan API Key’i kopyalayın.
5. API Key’i manifest dosyanıza ekleyin.
   API KEY şuna benzer birşey:
   <code>AIzaXXAYSzBmJbWtGaUH-pQqb0c2rRO-6N-Oeng</code>
   
   AndroidManifext.xml’de  </application> tag’inin hemen oncesine key’inizi şu kodla ekleyin:
   
   <code>...
   
		<meta-data
   			 android:name="com.google.android.maps.v2.API_KEY"
   		 android:value="AIzaXXAYSzBmJbWtGaUH-pQqb0c2rRO-6N-Oeng"/>
		
		</application>
   
   ...</code>
   
6. AndroidManifest’e izinleri ekleyin (Github'dan aldığınız kodların içinde bunlar var.)
   <code><permission android:name="org.istanbulhs.istanbulhsapp.permission.MAPS_RECEIVE"
        android:protectionLevel="signature"/>
		
		<uses-permission android:name="org.istanbulhs.istanbulhsapp.permission.MAPS_RECEIVE"/>
		
		<uses-feature android:glEsVersion="0x00020000" android:required="true" />
		
		<uses-permission android:name="com.google.android.providers.gsf.permission.READ_GSERVICES"/>
	</code>

   Fiziksel bir telefondaysanız calışması lazım:

   Eğer değilseniz emulatore Google Play Store yüklememiz gerekiyor.

7. &lt;ADT-Bundle’i-koyduğunuz-yer&gt;/adt-bundle-mac-x86_64/sdk/platform-tools
   *Windows*: <code>adb</code>
   *Linux, Mac*: <code>./adb</code>

   <code>./adb devices</code> : komutu ile bağlı cihazları görebilirsiniz

   Asağıdaki iki dosyayı bilgisayarınıza indirin:

   https://raw.github.com/istanbulhs/android-egitim/master/README-images/com.android.vending.apk
   https://raw.github.com/istanbulhs/android-egitim/master/README-images/com.google.android.gms.apk

   İndirdikten sonra adb ile cihaziniza şu şekilde kurun

   <code>adb install com.android.vending.apk</code>
   
   Success yazisini gordukten sonra ikincisini
   
   <code>adb install com.google.android.gms.apk</code>

   Bunda da success yazısını gördüyseniz artık uygulamanıza bir harita ekleyebilirsiniz. 


Kaynak: 
* https://developers.google.com/maps/documentation/android/start
* http://stackoverflow.com/questions/13691943/this-app-wont-run-unless-you-update-google-play-services-via-bazaar/13734937#comment15338651_21662620
