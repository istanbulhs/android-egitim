package org.istanbulhs.istanbulhsapp;

import java.util.Locale;

import org.istanbulhs.istanbulhsapp.fragments.ContactFragment;
import org.istanbulhs.istanbulhsapp.fragments.HackerspaceMapFragment;
import org.istanbulhs.istanbulhsapp.fragments.ItemFragment;
import org.istanbulhs.istanbulhsapp.fragments.NormalFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabNavigationActivity extends FragmentActivity  {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_navigation);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab_navigation, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		//Tab'in hangi sayfayi gosterecegi bu metodla donuyor
		@Override
		public Fragment getItem(int position) {
			//Tablara tiklayinca acilacak ekranlar asagida yaratiliyor
			Fragment fragment = null;
			switch (position) {
				case 0:
					//Giristeki fragment
					fragment = new NormalFragment(); 
					return fragment;
				case 1:
					//Kisi listesi
					fragment = new ItemFragment();
					return fragment;
				case 2:
					//İlk ekranda kaydettigimiz ismi burda yeniden okuyoruz
					fragment = new DummySectionFragment();
					Bundle args = new Bundle();
					args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
					fragment.setArguments(args);
					return fragment;
				case 3:
					//Kontakt listesi ekrani
					fragment = new ContactFragment();
					return fragment;
				case 4:
					//Harita fragmenti
					return new HackerspaceMapFragment();
			}
			return fragment;
		}

		//Kac tane tab varsa o rakam donuluyor
		@Override
		public int getCount() {
			//Toplam tab sayisi
			return 5;
		}

		//Tab basliklarini donen metod
		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return "BIZIM FRAGMENT";
			case 1:
				return "BIZIM LISTE";
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return "BIZIM KISILER";
			case 4: 
				return "BIZIM HARITA";
			}
			return null;
		}
	}
	
	
	//Ornek Fragment
	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_tab_navigation_dummy, container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			
			SharedPreferences preferences = getActivity().getPreferences(MODE_PRIVATE);
			String name = preferences.getString("name", "Isim yok");
			dummyTextView.setText(name);
						
			return rootView;
		}
	}

}
