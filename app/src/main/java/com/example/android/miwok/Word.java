package com.example.android.miwok;

/**
 * Created by jioke on 7/27/17.
 */

public class Word {

  /** Default translation of word **/
  private String mDefaultTranslation;

  /** Miwork translation of word **/
  private String mMiworkTranslation;

  /** Image associated with word **/
  private int mImageResoureId = NO_IMAGE_PROVIDED;

  /** Sound associated with word **/
  private int mSoundResourceId;

  private static final int NO_IMAGE_PROVIDED = -1;

  public Word(String defaultTranslation, String miworkTranslation, int soundResourceId) {
    mDefaultTranslation = defaultTranslation;
    mMiworkTranslation = miworkTranslation;
    mSoundResourceId = soundResourceId;
  }

  public Word(String defaultTranslation, String miworkTranslation, int imageResourceId, int
          soundResourceId) {
    mDefaultTranslation = defaultTranslation;
    mMiworkTranslation = miworkTranslation;
    mImageResoureId = imageResourceId;
    mSoundResourceId = soundResourceId;
  }

  /**
   *
   * Get default translation of word
   */

  public String getDefaultTranslation() {
    return mDefaultTranslation;
  }

  /**
   *
   * Get Miwork translation of word
   */

  public String getMiworkTranslation() {
    return mMiworkTranslation;
  }

  /**
   * Get image resource for word
   */

  public int getImageResoureId() {
    return mImageResoureId;
  }

  public boolean hasImage() {
    return mImageResoureId != NO_IMAGE_PROVIDED;
  }

  /**
   * Get sound resource for word
   */
  public int getSoundResourceId() {
    return mSoundResourceId;
  }

  @Override
  public String toString() {
    return "Word{" +
            "mDefaultTranslation='" + mDefaultTranslation + '\'' +
            ", mMiworkTranslation='" + mMiworkTranslation + '\'' +
            ", mImageResoureId=" + mImageResoureId +
            ", mSoundResourceId=" + mSoundResourceId +
            '}';
  }
}
