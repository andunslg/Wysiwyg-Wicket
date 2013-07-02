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
package com.googlecode.wicket.jquery.ui.plugins.wysiwyg.toolbar;

import com.googlecode.wicket.jquery.core.IJQueryWidget.JQueryWidget;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

import java.util.Locale;

/**
 * Provides a default {@link IWysiwygToolbar}
 *
 * @author sebfz1
 * @author solomax
 * @author andunslg
 */
public class DefaultWysiwygToolbar extends Panel implements IWysiwygToolbar
{
	private static final long serialVersionUID = 1L;
	private final WebMarkupContainer toolbar;

	/**
	 * Constructor
	 *
	 * @param id the markup-id
	 */
	public DefaultWysiwygToolbar(String id)
	{
		this(id, null);
	}

	/**
	 * Constructor
	 *
	 * @param id the markup-id
	 * @param model the {@link org.apache.wicket.model.IModel}
	 */
	//TODO: andunslg / solomax - Localize
	public DefaultWysiwygToolbar(String id, IModel<String> model)
	{
		super(id, model);

		getSession().setLocale(new Locale("english"));

		this.toolbar = new WebMarkupContainer("toolbar");
		this.toolbar.setMarkupId("bToolbar");

		//Adding Buttons with localisations
		ExternalLink fontSize= new ExternalLink("fontSize","#");
		fontSize.add(AttributeModifier.replace("title",new ResourceModel("fontSize")));
		toolbar.add(fontSize);

		ExternalLink bold= new ExternalLink("bold","#");
		ExternalLink italic= new ExternalLink("italic","#");
		ExternalLink strikethrough= new ExternalLink("strikethrough","#");
		ExternalLink underline= new ExternalLink("underline","#");

		bold.add(AttributeModifier.replace("title",new ResourceModel("bold")));
		italic.add(AttributeModifier.replace("title",new ResourceModel("italic")));
		strikethrough.add(AttributeModifier.replace("title",new ResourceModel("strikethrough")));
		underline.add(AttributeModifier.replace("title",new ResourceModel("underline")));

		toolbar.add(bold);
		toolbar.add(italic);
		toolbar.add(strikethrough);
		toolbar.add(underline);

		ExternalLink bullets= new ExternalLink("bullets","#");
		ExternalLink numbers= new ExternalLink("numbers","#");
		ExternalLink indent= new ExternalLink("indent","#");
		ExternalLink reduceIndent= new ExternalLink("reduceIndent","#");

		bullets.add(AttributeModifier.replace("title",new ResourceModel("bullets")));
		numbers.add(AttributeModifier.replace("title",new ResourceModel("numbers")));
		indent.add(AttributeModifier.replace("title",new ResourceModel("indent")));
		reduceIndent.add(AttributeModifier.replace("title",new ResourceModel("reduceIndent")));

		toolbar.add(bullets);
		toolbar.add(numbers);
		toolbar.add(indent);
		toolbar.add(reduceIndent);

		ExternalLink justifyLeft= new ExternalLink("justifyLeft","#");
		ExternalLink justifyCenter= new ExternalLink("justifyCenter","#");
		ExternalLink justifyRight= new ExternalLink("justifyRight","#");
		ExternalLink justifyFull= new ExternalLink("justifyFull","#");

		justifyLeft.add(AttributeModifier.replace("title",new ResourceModel("justifyLeft")));
		justifyCenter.add(AttributeModifier.replace("title",new ResourceModel("justifyCenter")));
		justifyRight.add(AttributeModifier.replace("title",new ResourceModel("justifyRight")));
		justifyFull.add(AttributeModifier.replace("title",new ResourceModel("justifyFull")));

		toolbar.add(justifyLeft);
		toolbar.add(justifyCenter);
		toolbar.add(justifyRight);
		toolbar.add(justifyFull);

		ExternalLink hyperlink= new ExternalLink("hyperlink","#");
		ExternalLink removeHyperlink= new ExternalLink("removeHyperlink","#");

		hyperlink.add(AttributeModifier.replace("title",new ResourceModel("hyperlink")));
		removeHyperlink.add(AttributeModifier.replace("title",new ResourceModel("removeHyperlink")));

		toolbar.add(hyperlink);
		toolbar.add(removeHyperlink);


		ExternalLink undo= new ExternalLink("undo","#");
		ExternalLink redo= new ExternalLink("redo","#");

		undo.add(AttributeModifier.replace("title",new ResourceModel("undo")));
		redo.add(AttributeModifier.replace("title",new ResourceModel("redo")));

		toolbar.add(undo);
		toolbar.add(redo);

		this.add(this.toolbar);
	}

	@Override
	public void attachToEditor(Component editor)
	{
		this.toolbar.add(AttributeModifier.replace("data-target", JQueryWidget.getSelector(editor)));
	}
}
