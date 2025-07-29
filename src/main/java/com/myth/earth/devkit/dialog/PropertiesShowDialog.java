package com.myth.earth.devkit.dialog;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.project.Project;

import javax.swing.*;
import java.awt.event.*;

/**
 * 非漫游数据查看弹窗
 *
 * @author zhouchao
 * @date 2025/7/29 下午8:58
 **/
public class PropertiesShowDialog extends JDialog {
    private Project    project;
    private JPanel     contentPane;
    private JButton    buttonOK;
    private JButton    buttonCancel;
    private JTextField keyTextField;
    private JTextField projectTextField;
    private JTextField globalTextField;

    public PropertiesShowDialog(Project project) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(400, 200);
        setTitle("非持久配置读取");
        setResizable(true);
        setLocationRelativeTo(null);
        this.project = project;

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // 点击 X 时调用 onCancel()
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // 遇到 ESCAPE 时调用 onCancel()
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String key = keyTextField.getText();
        if (key == null || key.isBlank()) {
            return;
        }

        String globalValue = PropertiesComponent.getInstance().getValue(key);
        globalTextField.setText(globalValue);

        if (project != null) {
            String projectValue = PropertiesComponent.getInstance(project).getValue(key);
            projectTextField.setText(projectValue);
        }
    }

    private void onCancel() {
        // 必要时在此处添加您的代码
        dispose();
    }
}
