/*
 * Zed Attack Proxy (ZAP) and its related class files.
 * 
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 * 
 * Copyright 2010 psiinon@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.zaproxy.zap.extension.history;

import java.awt.Component;

import javax.swing.JList;

import org.parosproxy.paros.Constant;
import org.parosproxy.paros.extension.ExtensionPopupMenuItem;
import org.parosproxy.paros.extension.history.ExtensionHistory;
import org.parosproxy.paros.model.HistoryReference;


/**
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class PopupMenuTag extends ExtensionPopupMenuItem {

	private static final long serialVersionUID = 1L;
	private ExtensionHistory extension = null;
    
    /**
     * 
     */
    public PopupMenuTag() {
        super();
 		initialize();
    }

    /**
     * @param label
     */
    public PopupMenuTag(String label) {
        super(label);
    }

	/**
	 * This method initializes this
	 */
	private void initialize() {
        this.setText(Constant.messages.getString("history.tags.popup"));

        this.addActionListener(new java.awt.event.ActionListener() { 

        	@Override
        	public void actionPerformed(java.awt.event.ActionEvent e) {
        	    
        	    HistoryReference ref = extension.getSelectedHistoryReference();
        	    if (ref != null) {
        	    	extension.showManageTagsDialog(ref, ref.getTags());
        	    }
        	}
        });

			
	}
	
    @Override
    public boolean isEnableForComponent(Component invoker) {
        if (invoker.getName() != null && invoker.getName().equals("ListLog")) {
            try {
                JList<?> list = (JList<?>) invoker;
                if (list.getSelectedIndex() >= 0) {
                    this.setEnabled(true);
                } else {
                    this.setEnabled(false);
                }
            } catch (Exception e) {}
            return true;
        }
        return false;
    }
    
    public void setExtension(ExtensionHistory extension) {
        this.extension = extension;
    }
    

	
}
