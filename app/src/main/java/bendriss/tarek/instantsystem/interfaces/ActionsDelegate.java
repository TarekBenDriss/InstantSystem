package bendriss.tarek.instantsystem.interfaces;

import bendriss.tarek.instantsystem.model.News;

/**
 * This interface, implemented in the main activity, will perform the click on an item in the recyclerView
 */
public interface ActionsDelegate {
    void redirectButton(News item);
}
