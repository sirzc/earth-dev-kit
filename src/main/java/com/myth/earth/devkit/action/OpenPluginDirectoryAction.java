package com.myth.earth.devkit.action;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.DumbAwareAction;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

/**
 * 打开插件的安装目录
 *
 * @author zhouchao
 * @date 2024/12/24 下午5:40
 **/
public class OpenPluginDirectoryAction extends DumbAwareAction {

    private static final Logger logger = Logger.getInstance(OpenPluginDirectoryAction.class);

    @Override
    public void actionPerformed(AnActionEvent e) {
        PluginId pluginId = PluginId.getId("com.myth.earth.earth-dev-kit");
        IdeaPluginDescriptor plugin = PluginManagerCore.getPlugin(pluginId);
        if (plugin == null) {
            return;
        }

        try {
            Path parent = plugin.getPluginPath().getParent();
            Desktop.getDesktop().open(parent.toFile());
        } catch (IOException ex) {
            logger.info("插件安装目录打开失败！异常原因：", ex);
        }
    }
}
