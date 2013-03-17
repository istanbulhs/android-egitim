package org.istanbulhs.istanbulhsapp.fragments;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.ListView;

/**
 * A fragment representing a list of Items.
 * <p />
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ContactFragment extends ListFragment implements LoaderCallbacks<Cursor> {

	private SimpleCursorAdapter adapter;
	//contacts'tan getirecegimiz alanlar
    static final String[] CONTACTS_SUMMARY_PROJECTION = new String[] {
        Contacts._ID,
        Contacts.DISPLAY_NAME,
        Contacts.CONTACT_STATUS,
        Contacts.CONTACT_PRESENCE,
        Contacts.PHOTO_ID,
        Contacts.LOOKUP_KEY,
    };
    
	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ContactFragment() {
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// Eğer data olmazsa gosterilecek string
        setEmptyText("No phone numbers");

        // önce boş bir adapter koyuyoruz. Sayfa ilk gösterildiğinde kullanılır
        adapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_2, null,
                new String[] { Contacts.DISPLAY_NAME, Contacts.CONTACT_STATUS },
                new int[] { android.R.id.text1, android.R.id.text2 }, 0);
        setListAdapter(adapter);
		// Ayrı bir thread'de loader çalışacak
		getLoaderManager().initLoader(0, null, (LoaderCallbacks<Cursor>)this);
		super.onActivityCreated(savedInstanceState);
	}
	
	//Asagidaki methodlar  LoaderCallbacks<Cursor> interface'inin metodlari
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		//Uri bir adres. Bu durumda baseUri Contacts (telefondaki telefon rehberinin)
		//adres bilgisini iceriyor
		Uri baseUri = Contacts.CONTENT_URI;
		    
	    //CursorLoader - cursor'e data yuklemeye yariyor
		// Cursor ise sonuclarinin tutuldugu bir yapi. Cursor'in icinde moveNext, moveFirst gibi metodlar var
		//sanki imleci, veya listenin ustunde bir oku gezdirir gibi satirlarin arasindan datalari okumaya yarar
	    return new CursorLoader(getActivity(), baseUri,
	            CONTACTS_SUMMARY_PROJECTION, null, null,
	            Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader,
			Cursor data) {
		//bos adapter'in icine datayi koyuyoruz
		adapter.swapCursor(data);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		//adapter'in icindeki datayi sifirliyoruz
		adapter.swapCursor(null);			
	}

}
