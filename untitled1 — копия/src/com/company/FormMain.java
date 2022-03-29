package com.company;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.Stack;

public class FormMain extends JFrame {

    private JButton ButtonToFile;

    private JButton ButtonFromFile;

    private JPanel FormMain;

    private JTable tableMain;

    private JScrollPane ScrollMain;

    private JButton sdvigArray;

    private JLabel resultat;

    public FormMain() {

        $$$setupUI$$$();

        this.setTitle("Чуркин Кирилл, таск 3, задание 25");

        this.setContentPane(FormMain);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();

        ru.vsu.cs.util.JTableUtils.initJTableForArray(tableMain, 40, true, true, false, true);

        ru.vsu.cs.util.JTableUtils.resizeJTable(tableMain, 1, 9);

        ButtonToFile.addActionListener(e -> {

            Stack stack = new Stack();

            int size = tableMain.getColumnCount();

            String[] temp = new String[size];

            for (int i = 0; i < size; i++) {

                try {

                    temp[i] = ru.vsu.cs.util.JTableUtils.readStringArrayFromJTable(tableMain)[i];

                }

                catch (Exception ex) {

                    ex.getMessage();

                }
            }

            String temp2;

            for (int i = size-1, j = 0; i >=size/2 ; i--,j++) {

                temp2 = temp[j];

                temp[j] = temp[i];

                temp[i] = temp2;

            }

            for (int i = 0; i < size; i++) {

                stack.push(temp[i].toCharArray()[0]);

            }

            ToFile toFile = new ToFile();

            toFile.ToFile(stack, "C:\\Users\\newli\\IdeaProjects\\untitled1 — копия\\src\\com\\company\\FormMain.txt");

        });

        ButtonFromFile.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                FromFile fromFile = new FromFile();

                Stack stack = fromFile.FromFile("C:\\Users\\newli\\IdeaProjects\\untitled1 — копия\\src\\com\\company\\FormMain.txt");

                String arr[] = new String[stack.size()];

                int size = stack.size();

                for (int i = 0; i < size; i++) {

                    arr[i] = String.valueOf(stack.get(stack.size()-1));

                    stack.pop();

                }

                String temp;

                for (int i = size-1, j = 0; i >=size/2 ; i--,j++) {

                    temp = arr[j];

                    arr[j] = arr[i];

                    arr[i] = temp;

                }

                ru.vsu.cs.util.JTableUtils.writeArrayToJTable(tableMain, arr);

            }
        });

        sdvigArray.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                Stack<Character> stack = new Stack();

                int size = tableMain.getColumnCount();

                String[] temp = new String[size];

                for (int i = 0; i < size; i++) {

                    try {

                        temp[i] = ru.vsu.cs.util.JTableUtils.readStringArrayFromJTable(tableMain)[i];

                    }

                    catch (Exception ex) {

                        ex.getMessage();

                    }
                }

                String temp2;

                for (int i = size-1, j = 0; i >=size/2 ; i--,j++) {

                    temp2 = temp[j];

                    temp[j] = temp[i];

                    temp[i] = temp2;

                }

                for (int i = 0; i < size; i++) {

                    stack.push(temp[i].toCharArray()[0]);

                }

                int sizeFirst = (stack.size()/2) - 1;

                int sizeSecond = sizeFirst + 1;

                int realSize = stack.size();

                if (stack.size() % 2 != 0) {

                    sizeSecond++;

                }

                char arr1[] = new char[(stack.size()/2)];

                char arr2[] = new char[(stack.size()/2)];

                int indexTemp = (stack.size()/2) - 1;

                for (int i = 0; i < realSize; i++){

                    if (i <=sizeFirst){

                        arr1[i] = stack.get(stack.size()-1);

                    }

                    else if (i >=sizeSecond) {

                        arr2[indexTemp] = stack.get(stack.size()-1);

                        indexTemp--;

                    }

                    stack.pop();

                }

                boolean result = true;

                for (int i = 0; i < realSize/2; i++){

                    if (arr1[i] == arr2[i]) {

                        continue;

                    }

                    result = false;

                }

                if (result) {

                    resultat.setText("Палиндром");

                }

                else{

                    resultat.setText("Не палиндром");

                }
            }
        });
    }

    //дальше барахолка

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        FormMain = new JPanel();
        FormMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(10, 10, 10, 10), 10, 10));
        ButtonToFile = new JButton();
        ButtonToFile.setText("Загрузить в файл");
        FormMain.add(ButtonToFile, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(275, 30), null, 0, false));
        ButtonFromFile = new JButton();
        ButtonFromFile.setText("Загрузить из файла");
        FormMain.add(ButtonFromFile, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        ScrollMain = new JScrollPane();
        FormMain.add(ScrollMain, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableMain = new JTable();
        ScrollMain.setViewportView(tableMain);
        sdvigArray = new JButton();
        sdvigArray.setText("Сдвинуть массив");
        FormMain.add(sdvigArray, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(275, 30), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return FormMain;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
