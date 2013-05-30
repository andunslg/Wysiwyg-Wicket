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


import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class WysiwygEditor extends Panel{
	String editorID;

	public WysiwygEditor(String id, String editorID){
		super(id);
		this.editorID=editorID;
		WebMarkupContainer bToolbar=new WebMarkupContainer("bToolbar"){
			@Override
			protected void onComponentTag(final ComponentTag tag){
				super.onComponentTag(tag);
				tag.put("data-target","#"+WysiwygEditor.this.editorID);
			}
		};
	}

	public WysiwygEditor(String id, IModel<?> model, String editorID){
		super(id,model);
		this.editorID=editorID;
		WebMarkupContainer bToolbar=new WebMarkupContainer("bToolbar"){
			@Override
			protected void onComponentTag(final ComponentTag tag){
				super.onComponentTag(tag);
				tag.put("data-target","#"+WysiwygEditor.this.editorID);
			}
		};
	}
}
