package com.jetbrains.rider.plugins.unreal.actions

import com.intellij.notification.Notification
import com.intellij.notification.NotificationAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.jetbrains.rider.model.PluginInstallLocation
import com.jetbrains.rider.model.rdRiderModel
import com.jetbrains.rider.projectView.solution

open class InstallEditorPluginToEngineAction(private val text: String = "Install in Engine") : NotificationAction(text) {
    override fun actionPerformed(e: AnActionEvent, notification: Notification) {
        notification.expire()
        val project = e.project ?: return
        e.presentation.isEnabled = false
        project.solution.rdRiderModel.installEditorPlugin.fire(PluginInstallLocation.Engine)
    }
}

open class InstallEditorPluginToGameAction(private val text: String = "Install in Game") : NotificationAction(text) {
    override fun actionPerformed(e: AnActionEvent, notification: Notification) {
        notification.expire()
        val project = e.project ?: return
        e.presentation.isEnabled = false
        project.solution.rdRiderModel.installEditorPlugin.fire(PluginInstallLocation.Game)
    }
}