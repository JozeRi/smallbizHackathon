package heroapps.com.smallbizhackathon.business.rafanotification;


/**
 * Created by Refael Ozeri on 7/27/15.
 */
public class RefaelsNotification {

  private String ticker, expandText, collapsedText;

  public RefaelsNotification(String ticker, String expandText, String collapsedText) {
    this.ticker = ticker;
    this.expandText = expandText;
    this.collapsedText = collapsedText;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public String getExpandText() {
    return expandText != null ? expandText : "";
  }

  public void setExpandText(String expandText) {
    this.expandText = expandText;
  }

  public String getCollapsedText() {
    return collapsedText;
  }

  public void setCollapsedText(String collapsedText) {
    this.collapsedText = collapsedText;
  }
}
