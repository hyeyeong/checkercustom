package com.adobe.epubcheck.reporting;

import com.adobe.epubcheck.util.FeatureEnum;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * This is information about the publication in general.  It is intended to be serialized into json.
 */
@SuppressWarnings({"FieldCanBeLocal", "MismatchedQueryAndUpdateOfCollection"})
public class PublicationMetadata
{
  @JsonProperty
  private String publisher;
  @JsonProperty
  private String title;
  @JsonProperty
  private final List<String> creator = new ArrayList<String>();
  @JsonProperty
  private String date;
  @JsonProperty
  private final List<String> subject = new ArrayList<String>();
  @JsonProperty
  private String description;
  @JsonProperty
  private String rights;
  @JsonProperty
  private String identifier;
  @JsonProperty
  private String language;
  @JsonProperty
  private int nSpines;
  @JsonProperty
  private long checkSum;
  @JsonProperty
  private String renditionLayout = "reflowable";
  @JsonProperty
  private String renditionOrientation = "auto";
  @JsonProperty
  private String renditionSpread = "auto";
  @JsonProperty
  private String ePubVersion;
  @JsonProperty
  private boolean isScripted = false;
  @JsonProperty
  private boolean hasFixedFormat = false;
  @JsonProperty
  private boolean isBackwardCompatible = true;
  @JsonProperty
  private boolean hasAudio = false;
  @JsonProperty
  private boolean hasVideo = false;
  @JsonProperty
  private long charsCount = 0;
  @JsonProperty
  private final Set<String> embeddedFonts = new LinkedHashSet<String>();
  @JsonProperty
  private final Set<String> refFonts = new LinkedHashSet<String>();
  @JsonProperty
  private boolean hasEncryption;
  @JsonProperty
  private boolean hasSignatures;
  @JsonProperty
  private final Set<String> contributors = new LinkedHashSet<String>();
  
  public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getnSpines() {
		return nSpines;
	}

	public void setnSpines(int nSpines) {
		this.nSpines = nSpines;
	}

	public long getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(long checkSum) {
		this.checkSum = checkSum;
	}

	public String getePubVersion() {
		return ePubVersion;
	}

	public void setePubVersion(String ePubVersion) {
		this.ePubVersion = ePubVersion;
	}

	public boolean isScripted() {
		return isScripted;
	}

	public void setScripted(boolean isScripted) {
		this.isScripted = isScripted;
	}

	public boolean isHasFixedFormat() {
		return hasFixedFormat;
	}

	public void setHasFixedFormat(boolean hasFixedFormat) {
		this.hasFixedFormat = hasFixedFormat;
	}

	public boolean isBackwardCompatible() {
		return isBackwardCompatible;
	}

	public void setBackwardCompatible(boolean isBackwardCompatible) {
		this.isBackwardCompatible = isBackwardCompatible;
	}

	public boolean isHasAudio() {
		return hasAudio;
	}

	public void setHasAudio(boolean hasAudio) {
		this.hasAudio = hasAudio;
	}

	public boolean isHasVideo() {
		return hasVideo;
	}

	public void setHasVideo(boolean hasVideo) {
		this.hasVideo = hasVideo;
	}

	public long getCharsCount() {
		return charsCount;
	}

	public void setCharsCount(long charsCount) {
		this.charsCount = charsCount;
	}

	public boolean isHasEncryption() {
		return hasEncryption;
	}

	public void setHasEncryption(boolean hasEncryption) {
		this.hasEncryption = hasEncryption;
	}

	public boolean isHasSignatures() {
		return hasSignatures;
	}

	public void setHasSignatures(boolean hasSignatures) {
		this.hasSignatures = hasSignatures;
	}

	public List<String> getCreator() {
		return creator;
	}

	public List<String> getSubject() {
		return subject;
	}

	public Set<String> getEmbeddedFonts() {
		return embeddedFonts;
	}

	public Set<String> getRefFonts() {
		return refFonts;
	}

	public Set<String> getContributors() {
		return contributors;
	}

	public void setRenditionLayout(String renditionLayout) {
		this.renditionLayout = renditionLayout;
	}

	public void setRenditionOrientation(String renditionOrientation) {
		this.renditionOrientation = renditionOrientation;
	}

	public void setRenditionSpread(String renditionSpread) {
		this.renditionSpread = renditionSpread;
	}

  public PublicationMetadata()
  {
  }

  public String getRenditionLayout()
  {
    return this.renditionLayout;
  }

  public String getRenditionOrientation()
  {
    return this.renditionOrientation;
  }

  public String getRenditionSpread()
  {
    return this.renditionSpread;
  }

  public void handleInfo(String resource, FeatureEnum feature, String value)
  {
    switch (feature)
    {
      case DC_TITLE:
        this.title = value;
        break;
      case DC_LANGUAGE:
        this.language = value;
        break;
      case DC_PUBLISHER:
        this.publisher = value;
        break;
      case DC_CREATOR:
        this.creator.add(value);
        break;
      case DC_RIGHTS:
        this.rights = value;
        break;
      case DC_SUBJECT:
        this.subject.add(value);
        break;
      case DC_DESCRIPTION:
        this.description = value;
        break;
      case MODIFIED_DATE:
        this.date = value;
        break;
      case UNIQUE_IDENT:
        if (resource == null)
        {
          this.identifier = value;
        }
        break;
      case FORMAT_VERSION:
        this.ePubVersion = value;
        break;
      case HAS_SCRIPTS:
        this.isScripted = true;
        this.isBackwardCompatible = false;
        break;
      case HAS_FIXED_LAYOUT:
        this.hasFixedFormat = true;
        this.isBackwardCompatible = false;
        break;
      case HAS_HTML5:
        if (resource == null)
        {
          this.isBackwardCompatible = false;
        }
        break;
      case IS_SPINEITEM:
        this.nSpines++;
        break;
      case HAS_NCX:
        if (!Boolean.parseBoolean(value))
        {
          this.isBackwardCompatible = false;
        }
        break;
      case RENDITION_LAYOUT:
        if (resource == null)
        {
          this.renditionLayout = value;
        }
        break;
      case RENDITION_ORIENTATION:
        if (resource == null)
        {
          this.renditionOrientation = value;
        }
        break;
      case RENDITION_SPREAD:
        if (resource == null)
        {
          this.renditionSpread = value;
        }
        break;
      case CHARS_COUNT:
        this.charsCount += Long.parseLong(value);
        break;
      case DECLARED_MIMETYPE:
        if (value != null && value.startsWith("audio/"))
        {
          this.hasAudio = true;
        }
        else if (value != null && value.startsWith("video/"))
        {
          this.hasVideo = true;
        }
        break;
      case FONT_EMBEDDED:
        this.embeddedFonts.add(value);
        break;
      case FONT_REFERENCE:
        this.refFonts.add(value);
        break;
      case HAS_SIGNATURES:
        this.hasSignatures = true;
        break;
      case HAS_ENCRYPTION:
        this.hasEncryption = true;
        break;
      case DC_CONTRIBUTOR:
        this.contributors.add(value);
        break;
    }
  }
}
