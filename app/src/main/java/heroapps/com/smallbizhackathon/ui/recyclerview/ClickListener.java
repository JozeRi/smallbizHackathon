package heroapps.com.smallbizhackathon.ui.recyclerview;

import android.view.View;

/**
 * Created by Refael Ozeri on 07/09/2016.
 */
public interface ClickListener {
  void onClick(View view, int position);
  void onLongClick(View view, int position);
}
