package edu.psu.ist.controller;


import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.view.SplitListView;

public class SplitListController {

    private ISplittableList<String> listModel;
    private SplitListView view;

    public SplitListController(ISplittableList<String> m,
                               SplitListView v) {
        this.listModel = m;
        this.view = v;

        // first thing we'll do in the constructor
        // (remember: this runs only once per run of the app) is set the initial
        // text rendering the (empty) list
        view.form.getListValueLabel().setText(listModel.toString());

        // TODO: (Start this only once the form is built --
        //        and the App class runs and displays your form)
        //   add action listeners to the various buttons and manipulate the listModel,
        //   updating the various components on the view when needed


        // add to right at front
        view.form.getAddToRightAtButton().addActionListener(e -> {
            String input = view.form.getElementInput().getText();
            listModel.addToRightAtFront(input);
            view.form.getListValueLabel().setText(listModel.toString() + "");
        });

        // todo: need to add error checking (example in dog video) for a couple things i htink

        // remove from right at front
        view.form.getRemoveFromRightAtButton().addActionListener(e -> {
            view.form.getLastRemoved().setText(listModel.removeFromRightAtFront() + "");
            //listModel.removeFromRightAtFront();
            view.form.getListValueLabel().setText(listModel.toString() + "");
        });


    }
}