package com.adobe.epubcheck.reporting;

import com.adobe.epubcheck.util.PathUtil;
import com.adobe.epubcheck.util.outWriter;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This describes properties about the checker.  It is intended to be serialized into json.
 */
@SuppressWarnings("FieldCanBeLocal")
public class CheckerMetadata
{
  @JsonProperty
  private String path;
  @JsonProperty
  private String filename;
  @JsonProperty
  private String checkerVersion;
  @JsonProperty
  private String checkDate;
  @JsonProperty
  private long elapsedTime = -1; // Elapsed Time in Seconds
  @JsonProperty
  private int nFatal = 0;
  @JsonProperty
  private int nError = 0;
  @JsonProperty
  private int nWarning = 0;
  @JsonProperty
  private int nUsage = 0;

  private final String workingDirectory  = System.getProperty("user.dir");
  
  public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public int getnFatal() {
		return nFatal;
	}

	public void setnFatal(int nFatal) {
		this.nFatal = nFatal;
	}

	public int getnError() {
		return nError;
	}

	public void setnError(int nError) {
		this.nError = nError;
	}

	public int getnWarning() {
		return nWarning;
	}

	public void setnWarning(int nWarning) {
		this.nWarning = nWarning;
	}

	public int getnUsage() {
		return nUsage;
	}

	public void setnUsage(int nUsage) {
		this.nUsage = nUsage;
	}

	public Date getProcessStartDateTime() {
		return processStartDateTime;
	}

	public void setProcessStartDateTime(Date processStartDateTime) {
		this.processStartDateTime = processStartDateTime;
	}

	public Date getProcessEndDateTime() {
		return processEndDateTime;
	}

	public void setProcessEndDateTime(Date processEndDateTime) {
		this.processEndDateTime = processEndDateTime;
	}

	public String getCheckerVersion() {
		return checkerVersion;
	}

	public String getWorkingDirectory() {
		return workingDirectory;
	}

	public static SimpleDateFormat getDateformat() {
		return dateFormat;
	}

  public void setFileInfo(File epubFile)
  {
    this.path = PathUtil.removeWorkingDirectory(epubFile.getAbsolutePath());
    this.filename = epubFile.getName();
  }

  private Date processStartDateTime;
  private Date processEndDateTime;
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

  public CheckerMetadata()
  {

  }

  public void setCheckerVersion(String value)
  {
    this.checkerVersion = value;
    //this.checkerVersion = "${pom.version}";
  }

  public long getProcessDuration()
  {
    if (elapsedTime == -1)
    {
      setElapsedTime();
    }

    return this.elapsedTime;
  }

  public void setStartDate()
  {
    this.processStartDateTime = new Date();
    this.checkDate = CheckerMetadata.dateFormat.format(this.processStartDateTime);
  }

  public void setStopDate()
  {
    this.processEndDateTime = new Date();
    this.setElapsedTime();
  }

  private void setElapsedTime()
  {
    this.elapsedTime = this.processEndDateTime.getTime()
        - this.processStartDateTime.getTime();
  }

  public void setMessageTypes(List<CheckMessage> messages)
  {
    for (CheckMessage message : messages)
    {
      if (message.getSeverity() != null)
      {
        switch (message.getSeverity())
        {
          case FATAL:
            nFatal++;
            break;
          case ERROR:
            nError++;
            break;
          case WARNING:
            nWarning++;
            break;
          case USAGE:
            nUsage++;
            break;
        }
      }
      else
      {
        outWriter.print("message with no severity");
      }
    }
  }
}
