package edu.psu.ist.controller;

import java.util.Stack;
import edu.psu.ist.model.ISplittableList;
import edu.psu.ist.view.SplitListView;

import javax.swing.*;

public class SplitListController {

    private ISplittableList<String> listModel;
    private SplitListView view;

    private Stack<ISplittableList<String>> undoStack = new Stack<>();

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
            if (input.equals("")){
                JOptionPane.showMessageDialog(view, "Error: text field is blank");
            } else {
                listModel.addToRightAtFront(input);
                view.form.getListValueLabel().setText(listModel.toString() + "");
                view.form.getRightLen().setText("Right Length: " + listModel.rightLength() + "");
            }});

        // todo: need to add error checking (example in dog video) for a couple things i htink

        // remove from right at front
        view.form.getRemoveFromRightAtButton().addActionListener(e -> {
            if (listModel.rightLength() == 0) {
                JOptionPane.showMessageDialog(view, "Error: right list is empty");
            } else {
            view.form.getLastRemoved().setText("Last Removed: " + listModel.removeFromRightAtFront() + "");
            view.form.getListValueLabel().setText(listModel.toString() + "");
            view.form.getRightLen().setText("Right Length: " + listModel.rightLength() + "");
        }});

        //move forward
        view.form.getMoveForwardButton().addActionListener(e -> {
            if (listModel.rightLength() == 0) {
                JOptionPane.showMessageDialog(view, "Error: right list is empty");
            } else {
            listModel.moveForward();
            view.form.getListValueLabel().setText(listModel.toString() + "");
            view.form.getLeftLen().setText("Left Length: " + listModel.leftLength() + "");
            view.form.getRightLen().setText("Right Length: " + listModel.rightLength() + "");
        }});

        //move to beginning
        view.form.getMoveToBeginningButton().addActionListener(e -> {
            listModel.moveToVeryBeginning();
            view.form.getListValueLabel().setText(listModel.toString() + "");
            view.form.getLeftLen().setText("Left Length: " + listModel.leftLength() + "");
            view.form.getRightLen().setText("Right Length: " + listModel.rightLength() + "");
        });

        //clear
        view.form.getClearButton().addActionListener(e -> {
            listModel.clear();
            view.form.getListValueLabel().setText(listModel.toString() + "");
            view.form.getLeftLen().setText("Left Length: " + listModel.leftLength() + "");
            view.form.getRightLen().setText("Right Length: " + listModel.rightLength() + "");
        });

        //count # of
        view.form.getCountOfButton().addActionListener(e -> {
            String inputCount = view.form.getElementInput().getText();
            int output = listModel.countOf(inputCount);
            JOptionPane.showMessageDialog(view, "Number of times " + inputCount + " occurs: " + output);
        });

    }
}