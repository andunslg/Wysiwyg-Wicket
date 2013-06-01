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
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class WysiwygEditor extends FormComponentPanel<WysiwygText> {

	public WysiwygEditor(String id){
		this(id,new Model<WysiwygText>());
	}

	public WysiwygEditor(String id, IModel<WysiwygText> model){
		super(id,model);
		this.add(new WysiwygBehavior("#editorArea","wysiwyg"));

		Form form=new Form("form");
		form.add(new AjaxSubmitLink("submitBtn") {
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				System.out.println(getRequest().getRequestParameters().getParameterValue("richText").toString());
			}
			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
			{
				super.updateAjaxAttributes(attributes);
				attributes.getDynamicExtraParameters().add("return [ {name: 'richText',value: $('#editorArea').html() } ]");
			}

		});
		this.add(form);

	}

	@Override
	public void convertInput(){

	}

	@Override
	public void onBeforeRender(){
		super.onBeforeRender();

//		}
	}
}
