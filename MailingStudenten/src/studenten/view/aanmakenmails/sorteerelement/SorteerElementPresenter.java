package studenten.view.aanmakenmails.sorteerelement;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import studenten.model.PeriodeResultaat;
import studenten.model.Student;

import java.util.Comparator;

public class SorteerElementPresenter {
    private SorteerElementView view;

    public SorteerElementPresenter(SorteerElementView view) {
        this.view = view;

        updateView();
        addEventHandlers();
    }

    private void updateView() {}

    private void addEventHandlers() {
        // todo: Save event handler here.
    }
}
