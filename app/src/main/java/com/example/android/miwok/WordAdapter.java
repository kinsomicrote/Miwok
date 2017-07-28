package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jioke on 7/27/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {

  /**Resource ID for the background color for the list of words*/
  private int mColorResourceId;

  public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.
    super(context, 0, words);
    mColorResourceId = colorResourceId;
  }

  /**
   * Provides a view for an AdapterView (ListView, GridView, etc.)
   *
   * @param position The position in the list of data that should be displayed in the
   *                 list item view.
   * @param convertView The recycled view to populate.
   * @param parent The parent ViewGroup that is used for inflation.
   * @return The View for the position in the AdapterView.
   */
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // Check if existing view is being reused, otherwise inflate the view
    View listItemView = convertView;
    if(listItemView == null) {
      listItemView = LayoutInflater.from(getContext()).inflate(
              R.layout.list_item, parent, false);
    }

    // Get the {@link Word} object located at this position in the list
    Word currentWord = getItem(position);

    TextView miworkTextView = (TextView) listItemView.findViewById(R.id.miwork_word);
    miworkTextView.setText(currentWord.getMiworkTranslation());

    TextView defaultTranslationTextView = (TextView) listItemView.findViewById(R.id.default_word);
    defaultTranslationTextView.setText(currentWord.getDefaultTranslation());

    ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

    if(currentWord.hasImage()) {
      // Set the ImageView to the image resource specified in the current Word
      imageView.setImageResource(currentWord.getImageResoureId());

      // Make sure the image is visible
      imageView.setVisibility((View.VISIBLE));
    }
    else {
      // Otherwise hide the imageView (set Visibility to GONE)
      imageView.setVisibility(View.GONE);
    }

    //Set the theme color for the list item
    View textContainer = listItemView.findViewById(R.id.text_container);
    //Find the color that the resource ID maps to
    int color = ContextCompat.getColor(getContext(), mColorResourceId);
    //Set the background color of the text container view
    textContainer.setBackgroundColor(color);

    return listItemView;
  }
}
