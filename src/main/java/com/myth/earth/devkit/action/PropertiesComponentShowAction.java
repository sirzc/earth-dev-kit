package com.myth.earth.devkit.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.myth.earth.devkit.dialog.PropertiesShowDialog;
import org.jetbrains.annotations.NotNull;

/**
 * 不可漫游的数据查看器
 *
 * @author zhouchao
 * @date 2025-07-29 下午8:56
 */
public class PropertiesComponentShowAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        PropertiesShowDialog propertiesShowDialog = new PropertiesShowDialog(anActionEvent.getProject());
        propertiesShowDialog.setVisible(true);
    }
}
