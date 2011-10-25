/*
 * Copyright (c) 2011 David Boissier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codinjutsu.tools.jenkins.view.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.codinjutsu.tools.jenkins.logic.JenkinsBrowserLogic;
import org.codinjutsu.tools.jenkins.model.Jenkins;
import org.codinjutsu.tools.jenkins.util.GuiUtil;

public class RefreshNodeAction extends AnAction {

    private final JenkinsBrowserLogic logic;


    public RefreshNodeAction(JenkinsBrowserLogic logic) {
        super("Refresh", "Refresh current node", GuiUtil.loadIcon("loadingTree.png"));
        this.logic = logic;
    }


    @Override
    public void actionPerformed(AnActionEvent e) {
        if (logic.getSelectedJob() != null) {
            logic.loadSelectedJob();
        } else {
            logic.loadSelectedView();
        }
    }


    @Override
    public void update(AnActionEvent event) {
        Jenkins jenkins = logic.getJenkins();
        event.getPresentation().setEnabled(jenkins != null || logic.getSelectedJob() != null);
    }


}
