package edu.psu.ist.view;

import javax.swing.*;

public class SplitListForm {
    private JPanel myPanel;
    private JLabel listValueLabel;
    private JTextField elementInput;
    private JButton addToRightAtButton;
    private JButton removeFromRightAtButton;
    private JButton moveForwardButton;
    private JButton moveToBeginningButton;
    private JButton clearButton;

    public JLabel getLastRemoved() {
        return LastRemoved;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JLabel getListValueLabel() {
        return listValueLabel;
    }

    public JTextField getElementInput() {
        return elementInput;
    }

    public JButton getAddToRightAtButton() {
        return addToRightAtButton;
    }

    public JButton getRemoveFromRightAtButton() {
        return removeFromRightAtButton;
    }

    public JButton getMoveForwardButton() {
        return moveForwardButton;
    }

    public JButton getMoveToBeginningButton() {
        return moveToBeginningButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getCountOfButton() {
        return countOfButton;
    }

    public JButton getUndoButton() {
        return undoButton;
    }

    private JButton countOfButton;
    private JButton undoButton;
    private JLabel LastRemoved;
}
