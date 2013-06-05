/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.jquery.ui.plugins.wysiwyg;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class WysiwygEditor extends FormComponentPanel<String> {
	private static final long serialVersionUID = 1L;
	private final TextArea<String> editor;
	private final WebMarkupContainer editorArea = new WebMarkupContainer("editorArea");

	public WysiwygEditor(String id) {
		this(id, null);
	}

	public WysiwygEditor(String id, IModel<String> model){
		this(id, model,null);
	}

	//FIXME Localize
	public WysiwygEditor(String id, IModel<String> model,WysiwygDefaultToolbar btnToolBar){
		super(id, model);

		add(editorArea.setOutputMarkupId(true));
		add((editor = new TextArea<String>("editor", Model.of(getModelObject()))).setOutputMarkupId(true));
		add(new WysiwygBehavior("#" + editorArea.getMarkupId(), "wysiwyg"));
		if(btnToolBar!=null){
			btnToolBar.attacheToEditor(editorArea.getMarkupId());
		}
	}

	@Override
	protected void onModelChanged() {
		super.onModelChanged();
		editor.setModelObject((String)getDefaultModelObject());
	}

	@Override
	protected void convertInput() {
		setConvertedInput(editor.getConvertedInput());
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(OnLoadHeaderItem.forScript(
				String.format("addTextAreaMapper('%s', '%s');", editorArea.getMarkupId(), editor.getMarkupId())));
	}

	public String getEditorMarkupID(){
		return editorArea.getMarkupId();
	}
}
