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
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.resource.PackageResourceReference;

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
	public DefaultWysiwygToolbar(String id, IModel<String> model)
	{
		super(id, model);

		getSession().setLocale(new Locale("english"));

		this.toolbar = new WebMarkupContainer("toolbar");
		this.toolbar.setMarkupId("bToolbar");

		//Adding Buttons with localizations
		toolbar.add(new WebMarkupContainer("fontSize").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.fontSize"))));

		toolbar.add(new Label("huge",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.huge")));
		toolbar.add(new Label("medium",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.medium")));
		toolbar.add(new Label("small",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.small")));

		toolbar.add(new WebMarkupContainer("bold").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.bold"))));
		toolbar.add(new WebMarkupContainer("italic").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.italic"))));
		toolbar.add(new WebMarkupContainer("strikethrough").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.strikethrough"))));
		toolbar.add(new WebMarkupContainer("underline").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.underline"))));

		toolbar.add(new WebMarkupContainer("bullets").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.bullets"))));
		toolbar.add(new WebMarkupContainer("numbers").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.numbers"))));
		toolbar.add(new WebMarkupContainer("indent").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.indent"))));
		toolbar.add(new WebMarkupContainer("reduceIndent").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.reduceIndent"))));

		toolbar.add(new WebMarkupContainer("justifyLeft").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.justifyLeft"))));
		toolbar.add(new WebMarkupContainer("justifyCenter").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.justifyCenter"))));
		toolbar.add(new WebMarkupContainer("justifyRight").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.justifyRight"))));
		toolbar.add(new WebMarkupContainer("justifyFull").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.justifyFull"))));

		toolbar.add(new WebMarkupContainer("hyperlink").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.hyperlink"))));
		toolbar.add(new WebMarkupContainer("removeHyperlink").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.removeHyperlink"))));

		toolbar.add(new WebMarkupContainer("undo").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.undo"))));
		toolbar.add(new WebMarkupContainer("redo").add(AttributeModifier.replace("title",new ResourceModel("wicket.jquery.ui.wysiwyg.toolbar.redo"))));

		this.add(this.toolbar);
	}

	@Override
	public void attachToEditor(Component editor)
	{
		this.toolbar.add(AttributeModifier.replace("data-target", JQueryWidget.getSelector(editor)));
	}
}

