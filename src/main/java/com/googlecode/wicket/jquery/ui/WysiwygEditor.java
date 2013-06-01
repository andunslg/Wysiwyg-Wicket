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
package com.googlecode.wicket.jquery.ui;


import com.googlecode.wicket.jquery.ui.plugins.wysiwyg.WysiwygBehavior;
import org.apache.wicket.markup.Markup;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.CssResourceReference;

import java.io.Serializable;

public class WysiwygEditor extends FormComponentPanel<WysiwygText>{
	//String editorID;
	WebMarkupContainer editorArea;

	public WysiwygEditor(String id){
		this(id,new Model<WysiwygText>());
	}

	public WysiwygEditor(String id, IModel<WysiwygText> model){
		super(id,model);
		editorArea=new WebMarkupContainer("editorArea",new Model<String>("Type Here..."));
		editorArea.setOutputMarkupId(true);
		editorArea.setMarkupId("editorArea");
		this.add(editorArea);
		this.add(new WysiwygBehavior("#editorArea","wysiwyg"));
//		this.editorID=editorID;
//		WebMarkupContainer bToolbar=new WebMarkupContainer("bToolbar"){
//			@Override
//			protected void onComponentTag(final ComponentTag tag){
//				super.onComponentTag(tag);
//				tag.put("data-target","#"+WysiwygEditor.this.editorID);
//			}
//		};
	}

	@Override
	public void convertInput(){
		WysiwygText wysiwygText=new WysiwygText((String)editorArea.getDefaultModelObject());
		System.out.println("---------------------------------------------------------------"+wysiwygText.getText());
		setConvertedInput(wysiwygText);
	}

	public void onBeforeRender(){
		super.onBeforeRender();
		WysiwygText wysiwygText=(WysiwygText)this.getDefaultModelObject();
		if(wysiwygText!=null){
			this.editorArea.setDefaultModelObject(wysiwygText.getText());
		}
	}
}
