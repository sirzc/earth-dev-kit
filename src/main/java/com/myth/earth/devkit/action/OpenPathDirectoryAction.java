package com.myth.earth.devkit.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.DumbAwareAction;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 打开全局配置位置
 *
 * @author zhouchao
 * @date 2024-12-24 下午6:17
 */
public class OpenPathDirectoryAction extends DumbAwareAction {

    private static final Logger logger = Logger.getInstance(OpenPathDirectoryAction.class);

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String configPath = PathManager.getConfigPath();
        File configDir = new File(configPath);
        if (configDir.exists() && configDir.isDirectory()) {
            try {
                Desktop.getDesktop().open(configDir);
            } catch (IOException ex) {
                logger.info("全局配置位置打开失败！异常原因：", ex);
            }
        }
    }
}
